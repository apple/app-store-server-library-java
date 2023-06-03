// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.JWSRenewalInfoDecodedPayload;
import com.apple.itunes.storekit.model.JWSTransactionDecodedPayload;
import com.apple.itunes.storekit.model.NotificationTypeV2;
import com.apple.itunes.storekit.model.ResponseBodyV2DecodedPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.Set;

public class SignedDataVerifierTest {

    private static final String ROOT_CA_BASE64_ENCODED = "MIIBgjCCASmgAwIBAgIJALUc5ALiH5pbMAoGCCqGSM49BAMDMDYxCzAJBgNVBAYTAlVTMRMwEQYDVQQIDApDYWxpZm9ybmlhMRIwEAYDVQQHDAlDdXBlcnRpbm8wHhcNMjMwMTA1MjEzMDIyWhcNMzMwMTAyMjEzMDIyWjA2MQswCQYDVQQGEwJVUzETMBEGA1UECAwKQ2FsaWZvcm5pYTESMBAGA1UEBwwJQ3VwZXJ0aW5vMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEc+/Bl+gospo6tf9Z7io5tdKdrlN1YdVnqEhEDXDShzdAJPQijamXIMHf8xWWTa1zgoYTxOKpbuJtDplz1XriTaMgMB4wDAYDVR0TBAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwCgYIKoZIzj0EAwMDRwAwRAIgemWQXnMAdTad2JDJWng9U4uBBL5mA7WI05H7oH7c6iQCIHiRqMjNfzUAyiu9h6rOU/K+iTR0I/3Y/NSWsXHX+acc";

    private static final String TEST_NOTIFICATION = "eyJ4NWMiOlsiTUlJQm9EQ0NBVWFnQXdJQkFnSUJDekFLQmdncWhrak9QUVFEQWpCTk1Rc3dDUVlEVlFRR0V3SlZVekVUTUJFR0ExVUVDQXdLUTJGc2FXWnZjbTVwWVRFU01CQUdBMVVFQnd3SlEzVndaWEowYVc1dk1SVXdFd1lEVlFRS0RBeEpiblJsY20xbFpHbGhkR1V3SGhjTk1qTXdNVEEwTVRZek56TXhXaGNOTXpJeE1qTXhNVFl6TnpNeFdqQkZNUXN3Q1FZRFZRUUdFd0pWVXpFVE1CRUdBMVVFQ0F3S1EyRnNhV1p2Y201cFlURVNNQkFHQTFVRUJ3d0pRM1Z3WlhKMGFXNXZNUTB3Q3dZRFZRUUtEQVJNWldGbU1Ga3dFd1lIS29aSXpqMENBUVlJS29aSXpqMERBUWNEUWdBRTRyV0J4R21GYm5QSVBRSTB6c0JLekx4c2o4cEQydnFicjB5UElTVXgyV1F5eG1yTnFsOWZoSzhZRUV5WUZWNysrcDVpNFlVU1Ivbzl1UUlnQ1BJaHJLTWZNQjB3Q1FZRFZSMFRCQUl3QURBUUJnb3Foa2lHOTJOa0Jnc0JCQUlUQURBS0JnZ3Foa2pPUFFRREFnTklBREJGQWlFQWtpRVprb0ZNa2o0Z1huK1E5alhRWk1qWjJnbmpaM2FNOE5ZcmdmVFVpdlFDSURKWVowRmFMZTduU0lVMkxXTFRrNXRYVENjNEU4R0pTWWYvc1lSeEVGaWUiLCJNSUlCbHpDQ0FUMmdBd0lCQWdJQkJqQUtCZ2dxaGtqT1BRUURBakEyTVFzd0NRWURWUVFHRXdKVlV6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVTTUJBR0ExVUVCd3dKUTNWd1pYSjBhVzV2TUI0WERUSXpNREV3TkRFMk1qWXdNVm9YRFRNeU1USXpNVEUyTWpZd01Wb3dUVEVMTUFrR0ExVUVCaE1DVlZNeEV6QVJCZ05WQkFnTUNrTmhiR2xtYjNKdWFXRXhFakFRQmdOVkJBY01DVU4xY0dWeWRHbHViekVWTUJNR0ExVUVDZ3dNU1c1MFpYSnRaV1JwWVhSbE1Ga3dFd1lIS29aSXpqMENBUVlJS29aSXpqMERBUWNEUWdBRUZRM2xYMnNxTjlHSXdBaWlNUURRQy9reW5TZ1g0N1J3dmlET3RNWFh2eUtkUWU2Q1BzUzNqbzJ1UkR1RXFBeFdlT2lDcmpsRFdzeXo1d3dkVTBndGFxTWxNQ013RHdZRFZSMFRCQWd3QmdFQi93SUJBREFRQmdvcWhraUc5Mk5rQmdJQkJBSVRBREFLQmdncWhrak9QUVFEQWdOSUFEQkZBaUVBdm56TWNWMjY4Y1JiMS9GcHlWMUVoVDNXRnZPenJCVVdQNi9Ub1RoRmF2TUNJRmJhNXQ2WUt5MFIySkR0eHF0T2pKeTY2bDZWN2QvUHJBRE5wa21JUFcraSIsIk1JSUJYRENDQVFJQ0NRQ2ZqVFVHTERuUjlqQUtCZ2dxaGtqT1BRUURBekEyTVFzd0NRWURWUVFHRXdKVlV6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVTTUJBR0ExVUVCd3dKUTNWd1pYSjBhVzV2TUI0WERUSXpNREV3TkRFMk1qQXpNbG9YRFRNek1ERXdNVEUyTWpBek1sb3dOakVMTUFrR0ExVUVCaE1DVlZNeEV6QVJCZ05WQkFnTUNrTmhiR2xtYjNKdWFXRXhFakFRQmdOVkJBY01DVU4xY0dWeWRHbHViekJaTUJNR0J5cUdTTTQ5QWdFR0NDcUdTTTQ5QXdFSEEwSUFCSFB2d1pmb0tMS2FPclgvV2U0cU9iWFNuYTVUZFdIVlo2aElSQTF3MG9jM1FDVDBJbzJwbHlEQjMvTVZsazJ0YzRLR0U4VGlxVzdpYlE2WmM5VjY0azB3Q2dZSUtvWkl6ajBFQXdNRFNBQXdSUUloQU1USGhXdGJBUU4waFN4SVhjUDRDS3JEQ0gvZ3N4V3B4NmpUWkxUZVorRlBBaUIzNW53azVxMHpjSXBlZnZZSjBNVS95R0dIU1dlejBicTBwRFlVTy9ubUR3PT0iXSwidHlwIjoiSldUIiwiYWxnIjoiRVMyNTYifQ.eyJkYXRhIjp7ImFwcEFwcGxlSWQiOjEyMzQsImVudmlyb25tZW50IjoiU2FuZGJveCIsImJ1bmRsZUlkIjoiY29tLmV4YW1wbGUifSwibm90aWZpY2F0aW9uVVVJRCI6IjlhZDU2YmQyLTBiYzYtNDJlMC1hZjI0LWZkOTk2ZDg3YTFlNiIsInNpZ25lZERhdGUiOjE2ODEzMTQzMjQwMDAsIm5vdGlmaWNhdGlvblR5cGUiOiJURVNUIn0.VVXYwuNm2Y3XsOUva-BozqatRCsDuykA7xIe_CCRw6aIAAxJ1nb2sw871jfZ6dcgNhUuhoZ93hfbc1v_5zB7Og";
    private static final String MISSING_X5C_HEADER_CLAIM = "eyJ0eXAiOiJKV1QiLCJhbGciOiJFUzI1NiIsIng1Y3dyb25nIjpbIk1JSUJvRENDQVVhZ0F3SUJBZ0lCRERBS0JnZ3Foa2pPUFFRREF6QkZNUXN3Q1FZRFZRUUdFd0pWVXpFTE1Ba0dBMVVFQ0F3Q1EwRXhFakFRQmdOVkJBY01DVU4xY0dWeWRHbHViekVWTUJNR0ExVUVDZ3dNU1c1MFpYSnRaV1JwWVhSbE1CNFhEVEl6TURFd05USXhNekV6TkZvWERUTXpNREV3TVRJeE16RXpORm93UFRFTE1Ba0dBMVVFQmhNQ1ZWTXhDekFKQmdOVkJBZ01Ba05CTVJJd0VBWURWUVFIREFsRGRYQmxjblJwYm04eERUQUxCZ05WQkFvTUJFeGxZV1l3V1RBVEJnY3Foa2pPUFFJQkJnZ3Foa2pPUFFNQkJ3TkNBQVRpdFlIRWFZVnVjOGc5QWpUT3dFck12R3lQeWtQYStwdXZUSThoSlRIWlpETEdhczJxWDErRXJ4Z1FUSmdWWHY3Nm5tTGhoUkpIK2oyNUFpQUk4aUdzb3k4d0xUQUpCZ05WSFJNRUFqQUFNQTRHQTFVZER3RUIvd1FFQXdJSGdEQVFCZ29xaGtpRzkyTmtCZ3NCQkFJRkFEQUtCZ2dxaGtqT1BRUURBd05JQURCRkFpQlg0YytUMEZwNW5KNVFSQ2xSZnU1UFNCeVJ2TlB0dWFUc2swdlBCM1dBSUFJaEFOZ2FhdUFqL1lQOXMwQWtFaHlKaHhRTy82UTJ6b3VaK0gxQ0lPZWhuTXpRIiwiTUlJQm56Q0NBVVdnQXdJQkFnSUJDekFLQmdncWhrak9QUVFEQXpBMk1Rc3dDUVlEVlFRR0V3SlZVekVUTUJFR0ExVUVDQXdLUTJGc2FXWnZjbTVwWVRFU01CQUdBMVVFQnd3SlEzVndaWEowYVc1dk1CNFhEVEl6TURFd05USXhNekV3TlZvWERUTXpNREV3TVRJeE16RXdOVm93UlRFTE1Ba0dBMVVFQmhNQ1ZWTXhDekFKQmdOVkJBZ01Ba05CTVJJd0VBWURWUVFIREFsRGRYQmxjblJwYm04eEZUQVRCZ05WQkFvTURFbHVkR1Z5YldWa2FXRjBaVEJaTUJNR0J5cUdTTTQ5QWdFR0NDcUdTTTQ5QXdFSEEwSUFCQlVONVY5cktqZlJpTUFJb2pFQTBBdjVNcDBvRitPMGNMNGd6clRGMTc4aW5VSHVnajdFdDQ2TnJrUTdoS2dNVm5qb2dxNDVRMXJNcytjTUhWTklMV3FqTlRBek1BOEdBMVVkRXdRSU1BWUJBZjhDQVFBd0RnWURWUjBQQVFIL0JBUURBZ0VHTUJBR0NpcUdTSWIzWTJRR0FnRUVBZ1VBTUFvR0NDcUdTTTQ5QkFNREEwZ0FNRVVDSVFDbXNJS1lzNDF1bGxzc0hYNHJWdmVVVDBaN0lzNS9oTEsxbEZQVHR1bjNoQUlnYzIrMlJHNStnTmNGVmNzK1hKZUVsNEdaK29qbDNST09tbGwreWU3ZHluUT0iLCJNSUlCZ2pDQ0FTbWdBd0lCQWdJSkFMVWM1QUxpSDVwYk1Bb0dDQ3FHU000OUJBTURNRFl4Q3pBSkJnTlZCQVlUQWxWVE1STXdFUVlEVlFRSURBcERZV3hwWm05eWJtbGhNUkl3RUFZRFZRUUhEQWxEZFhCbGNuUnBibTh3SGhjTk1qTXdNVEExTWpFek1ESXlXaGNOTXpNd01UQXlNakV6TURJeVdqQTJNUXN3Q1FZRFZRUUdFd0pWVXpFVE1CRUdBMVVFQ0F3S1EyRnNhV1p2Y201cFlURVNNQkFHQTFVRUJ3d0pRM1Z3WlhKMGFXNXZNRmt3RXdZSEtvWkl6ajBDQVFZSUtvWkl6ajBEQVFjRFFnQUVjKy9CbCtnb3NwbzZ0ZjlaN2lvNXRkS2RybE4xWWRWbnFFaEVEWERTaHpkQUpQUWlqYW1YSU1IZjh4V1dUYTF6Z29ZVHhPS3BidUp0RHBsejFYcmlUYU1nTUI0d0RBWURWUjBUQkFVd0F3RUIvekFPQmdOVkhROEJBZjhFQkFNQ0FRWXdDZ1lJS29aSXpqMEVBd01EUndBd1JBSWdlbVdRWG5NQWRUYWQySkRKV25nOVU0dUJCTDVtQTdXSTA1SDdvSDdjNmlRQ0lIaVJxTWpOZnpVQXlpdTloNnJPVS9LK2lUUjBJLzNZL05TV3NYSFgrYWNjIl19.eyJkYXRhIjp7ImJ1bmRsZUlkIjoiY29tLmV4YW1wbGUifSwibm90aWZpY2F0aW9uVVVJRCI6IjlhZDU2YmQyLTBiYzYtNDJlMC1hZjI0LWZkOTk2ZDg3YTFlNiIsIm5vdGlmaWNhdGlvblR5cGUiOiJURVNUIn0.1TFhjDR4WwQJNgizVGYXz3WE3ajxTdH1wKLQQ71MtrkadSxxOo3yPo_6L9Z03unIU7YK-NRNzSIb5bh5WqTprQ";
    private static final String WRONG_BUNDLE_ID = "eyJ4NWMiOlsiTUlJQm9EQ0NBVWFnQXdJQkFnSUJEREFLQmdncWhrak9QUVFEQXpCRk1Rc3dDUVlEVlFRR0V3SlZVekVMTUFrR0ExVUVDQXdDUTBFeEVqQVFCZ05WQkFjTUNVTjFjR1Z5ZEdsdWJ6RVZNQk1HQTFVRUNnd01TVzUwWlhKdFpXUnBZWFJsTUI0WERUSXpNREV3TlRJeE16RXpORm9YRFRNek1ERXdNVEl4TXpFek5Gb3dQVEVMTUFrR0ExVUVCaE1DVlZNeEN6QUpCZ05WQkFnTUFrTkJNUkl3RUFZRFZRUUhEQWxEZFhCbGNuUnBibTh4RFRBTEJnTlZCQW9NQkV4bFlXWXdXVEFUQmdjcWhrak9QUUlCQmdncWhrak9QUU1CQndOQ0FBVGl0WUhFYVlWdWM4ZzlBalRPd0VyTXZHeVB5a1BhK3B1dlRJOGhKVEhaWkRMR2FzMnFYMStFcnhnUVRKZ1ZYdjc2bm1MaGhSSkgrajI1QWlBSThpR3NveTh3TFRBSkJnTlZIUk1FQWpBQU1BNEdBMVVkRHdFQi93UUVBd0lIZ0RBUUJnb3Foa2lHOTJOa0Jnc0JCQUlGQURBS0JnZ3Foa2pPUFFRREF3TklBREJGQWlCWDRjK1QwRnA1bko1UVJDbFJmdTVQU0J5UnZOUHR1YVRzazB2UEIzV0FJQUloQU5nYWF1QWovWVA5czBBa0VoeUpoeFFPLzZRMnpvdVorSDFDSU9laG5NelEiLCJNSUlCbnpDQ0FVV2dBd0lCQWdJQkN6QUtCZ2dxaGtqT1BRUURBekEyTVFzd0NRWURWUVFHRXdKVlV6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVTTUJBR0ExVUVCd3dKUTNWd1pYSjBhVzV2TUI0WERUSXpNREV3TlRJeE16RXdOVm9YRFRNek1ERXdNVEl4TXpFd05Wb3dSVEVMTUFrR0ExVUVCaE1DVlZNeEN6QUpCZ05WQkFnTUFrTkJNUkl3RUFZRFZRUUhEQWxEZFhCbGNuUnBibTh4RlRBVEJnTlZCQW9NREVsdWRHVnliV1ZrYVdGMFpUQlpNQk1HQnlxR1NNNDlBZ0VHQ0NxR1NNNDlBd0VIQTBJQUJCVU41VjlyS2pmUmlNQUlvakVBMEF2NU1wMG9GK08wY0w0Z3pyVEYxNzhpblVIdWdqN0V0NDZOcmtRN2hLZ01WbmpvZ3E0NVExck1zK2NNSFZOSUxXcWpOVEF6TUE4R0ExVWRFd1FJTUFZQkFmOENBUUF3RGdZRFZSMFBBUUgvQkFRREFnRUdNQkFHQ2lxR1NJYjNZMlFHQWdFRUFnVUFNQW9HQ0NxR1NNNDlCQU1EQTBnQU1FVUNJUUNtc0lLWXM0MXVsbHNzSFg0clZ2ZVVUMFo3SXM1L2hMSzFsRlBUdHVuM2hBSWdjMisyUkc1K2dOY0ZWY3MrWEplRWw0R1orb2psM1JPT21sbCt5ZTdkeW5RPSIsIk1JSUJnakNDQVNtZ0F3SUJBZ0lKQUxVYzVBTGlINXBiTUFvR0NDcUdTTTQ5QkFNRE1EWXhDekFKQmdOVkJBWVRBbFZUTVJNd0VRWURWUVFJREFwRFlXeHBabTl5Ym1saE1SSXdFQVlEVlFRSERBbERkWEJsY25ScGJtOHdIaGNOTWpNd01UQTFNakV6TURJeVdoY05Nek13TVRBeU1qRXpNREl5V2pBMk1Rc3dDUVlEVlFRR0V3SlZVekVUTUJFR0ExVUVDQXdLUTJGc2FXWnZjbTVwWVRFU01CQUdBMVVFQnd3SlEzVndaWEowYVc1dk1Ga3dFd1lIS29aSXpqMENBUVlJS29aSXpqMERBUWNEUWdBRWMrL0JsK2dvc3BvNnRmOVo3aW81dGRLZHJsTjFZZFZucUVoRURYRFNoemRBSlBRaWphbVhJTUhmOHhXV1RhMXpnb1lUeE9LcGJ1SnREcGx6MVhyaVRhTWdNQjR3REFZRFZSMFRCQVV3QXdFQi96QU9CZ05WSFE4QkFmOEVCQU1DQVFZd0NnWUlLb1pJemowRUF3TURSd0F3UkFJZ2VtV1FYbk1BZFRhZDJKREpXbmc5VTR1QkJMNW1BN1dJMDVIN29IN2M2aVFDSUhpUnFNak5melVBeWl1OWg2ck9VL0sraVRSMEkvM1kvTlNXc1hIWCthY2MiXSwidHlwIjoiSldUIiwiYWxnIjoiRVMyNTYifQ.eyJkYXRhIjp7ImJ1bmRsZUlkIjoiY29tLmV4YW1wbGUud3JvbmcifSwibm90aWZpY2F0aW9uVVVJRCI6IjlhZDU2YmQyLTBiYzYtNDJlMC1hZjI0LWZkOTk2ZDg3YTFlNiIsIm5vdGlmaWNhdGlvblR5cGUiOiJURVNUIn0.WWE31hTB_mcv2O_lf-xI-MNY3d8txc0MzpqFx4QnYDfFIxB95Lo2Fm3r46YSjLLdL7xCWdEJrJP5bHgRCejAGg";
    private static final String RENEWAL_INFO = "eyJ4NWMiOlsiTUlJQm9EQ0NBVWFnQXdJQkFnSUJEREFLQmdncWhrak9QUVFEQXpCRk1Rc3dDUVlEVlFRR0V3SlZVekVMTUFrR0ExVUVDQXdDUTBFeEVqQVFCZ05WQkFjTUNVTjFjR1Z5ZEdsdWJ6RVZNQk1HQTFVRUNnd01TVzUwWlhKdFpXUnBZWFJsTUI0WERUSXpNREV3TlRJeE16RXpORm9YRFRNek1ERXdNVEl4TXpFek5Gb3dQVEVMTUFrR0ExVUVCaE1DVlZNeEN6QUpCZ05WQkFnTUFrTkJNUkl3RUFZRFZRUUhEQWxEZFhCbGNuUnBibTh4RFRBTEJnTlZCQW9NQkV4bFlXWXdXVEFUQmdjcWhrak9QUUlCQmdncWhrak9QUU1CQndOQ0FBVGl0WUhFYVlWdWM4ZzlBalRPd0VyTXZHeVB5a1BhK3B1dlRJOGhKVEhaWkRMR2FzMnFYMStFcnhnUVRKZ1ZYdjc2bm1MaGhSSkgrajI1QWlBSThpR3NveTh3TFRBSkJnTlZIUk1FQWpBQU1BNEdBMVVkRHdFQi93UUVBd0lIZ0RBUUJnb3Foa2lHOTJOa0Jnc0JCQUlGQURBS0JnZ3Foa2pPUFFRREF3TklBREJGQWlCWDRjK1QwRnA1bko1UVJDbFJmdTVQU0J5UnZOUHR1YVRzazB2UEIzV0FJQUloQU5nYWF1QWovWVA5czBBa0VoeUpoeFFPLzZRMnpvdVorSDFDSU9laG5NelEiLCJNSUlCbnpDQ0FVV2dBd0lCQWdJQkN6QUtCZ2dxaGtqT1BRUURBekEyTVFzd0NRWURWUVFHRXdKVlV6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVTTUJBR0ExVUVCd3dKUTNWd1pYSjBhVzV2TUI0WERUSXpNREV3TlRJeE16RXdOVm9YRFRNek1ERXdNVEl4TXpFd05Wb3dSVEVMTUFrR0ExVUVCaE1DVlZNeEN6QUpCZ05WQkFnTUFrTkJNUkl3RUFZRFZRUUhEQWxEZFhCbGNuUnBibTh4RlRBVEJnTlZCQW9NREVsdWRHVnliV1ZrYVdGMFpUQlpNQk1HQnlxR1NNNDlBZ0VHQ0NxR1NNNDlBd0VIQTBJQUJCVU41VjlyS2pmUmlNQUlvakVBMEF2NU1wMG9GK08wY0w0Z3pyVEYxNzhpblVIdWdqN0V0NDZOcmtRN2hLZ01WbmpvZ3E0NVExck1zK2NNSFZOSUxXcWpOVEF6TUE4R0ExVWRFd1FJTUFZQkFmOENBUUF3RGdZRFZSMFBBUUgvQkFRREFnRUdNQkFHQ2lxR1NJYjNZMlFHQWdFRUFnVUFNQW9HQ0NxR1NNNDlCQU1EQTBnQU1FVUNJUUNtc0lLWXM0MXVsbHNzSFg0clZ2ZVVUMFo3SXM1L2hMSzFsRlBUdHVuM2hBSWdjMisyUkc1K2dOY0ZWY3MrWEplRWw0R1orb2psM1JPT21sbCt5ZTdkeW5RPSIsIk1JSUJnakNDQVNtZ0F3SUJBZ0lKQUxVYzVBTGlINXBiTUFvR0NDcUdTTTQ5QkFNRE1EWXhDekFKQmdOVkJBWVRBbFZUTVJNd0VRWURWUVFJREFwRFlXeHBabTl5Ym1saE1SSXdFQVlEVlFRSERBbERkWEJsY25ScGJtOHdIaGNOTWpNd01UQTFNakV6TURJeVdoY05Nek13TVRBeU1qRXpNREl5V2pBMk1Rc3dDUVlEVlFRR0V3SlZVekVUTUJFR0ExVUVDQXdLUTJGc2FXWnZjbTVwWVRFU01CQUdBMVVFQnd3SlEzVndaWEowYVc1dk1Ga3dFd1lIS29aSXpqMENBUVlJS29aSXpqMERBUWNEUWdBRWMrL0JsK2dvc3BvNnRmOVo3aW81dGRLZHJsTjFZZFZucUVoRURYRFNoemRBSlBRaWphbVhJTUhmOHhXV1RhMXpnb1lUeE9LcGJ1SnREcGx6MVhyaVRhTWdNQjR3REFZRFZSMFRCQVV3QXdFQi96QU9CZ05WSFE4QkFmOEVCQU1DQVFZd0NnWUlLb1pJemowRUF3TURSd0F3UkFJZ2VtV1FYbk1BZFRhZDJKREpXbmc5VTR1QkJMNW1BN1dJMDVIN29IN2M2aVFDSUhpUnFNak5melVBeWl1OWg2ck9VL0sraVRSMEkvM1kvTlNXc1hIWCthY2MiXSwidHlwIjoiSldUIiwiYWxnIjoiRVMyNTYifQ.eyJlbnZpcm9ubWVudCI6IlNhbmRib3giLCJzaWduZWREYXRlIjoxNjcyOTU2MTU0MDAwfQ.FbK2OL-t6l4892W7fzWyus_g9mIl2CzWLbVt7Kgcnt6zzVulF8bzovgpe0v_y490blROGixy8KDoe2dSU53-Xw";
    private static final String TRANSACTION_INFO = "eyJ4NWMiOlsiTUlJQm9EQ0NBVWFnQXdJQkFnSUJDekFLQmdncWhrak9QUVFEQWpCTk1Rc3dDUVlEVlFRR0V3SlZVekVUTUJFR0ExVUVDQXdLUTJGc2FXWnZjbTVwWVRFU01CQUdBMVVFQnd3SlEzVndaWEowYVc1dk1SVXdFd1lEVlFRS0RBeEpiblJsY20xbFpHbGhkR1V3SGhjTk1qTXdNVEEwTVRZek56TXhXaGNOTXpJeE1qTXhNVFl6TnpNeFdqQkZNUXN3Q1FZRFZRUUdFd0pWVXpFVE1CRUdBMVVFQ0F3S1EyRnNhV1p2Y201cFlURVNNQkFHQTFVRUJ3d0pRM1Z3WlhKMGFXNXZNUTB3Q3dZRFZRUUtEQVJNWldGbU1Ga3dFd1lIS29aSXpqMENBUVlJS29aSXpqMERBUWNEUWdBRTRyV0J4R21GYm5QSVBRSTB6c0JLekx4c2o4cEQydnFicjB5UElTVXgyV1F5eG1yTnFsOWZoSzhZRUV5WUZWNysrcDVpNFlVU1Ivbzl1UUlnQ1BJaHJLTWZNQjB3Q1FZRFZSMFRCQUl3QURBUUJnb3Foa2lHOTJOa0Jnc0JCQUlUQURBS0JnZ3Foa2pPUFFRREFnTklBREJGQWlFQWtpRVprb0ZNa2o0Z1huK1E5alhRWk1qWjJnbmpaM2FNOE5ZcmdmVFVpdlFDSURKWVowRmFMZTduU0lVMkxXTFRrNXRYVENjNEU4R0pTWWYvc1lSeEVGaWUiLCJNSUlCbHpDQ0FUMmdBd0lCQWdJQkJqQUtCZ2dxaGtqT1BRUURBakEyTVFzd0NRWURWUVFHRXdKVlV6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVTTUJBR0ExVUVCd3dKUTNWd1pYSjBhVzV2TUI0WERUSXpNREV3TkRFMk1qWXdNVm9YRFRNeU1USXpNVEUyTWpZd01Wb3dUVEVMTUFrR0ExVUVCaE1DVlZNeEV6QVJCZ05WQkFnTUNrTmhiR2xtYjNKdWFXRXhFakFRQmdOVkJBY01DVU4xY0dWeWRHbHViekVWTUJNR0ExVUVDZ3dNU1c1MFpYSnRaV1JwWVhSbE1Ga3dFd1lIS29aSXpqMENBUVlJS29aSXpqMERBUWNEUWdBRUZRM2xYMnNxTjlHSXdBaWlNUURRQy9reW5TZ1g0N1J3dmlET3RNWFh2eUtkUWU2Q1BzUzNqbzJ1UkR1RXFBeFdlT2lDcmpsRFdzeXo1d3dkVTBndGFxTWxNQ013RHdZRFZSMFRCQWd3QmdFQi93SUJBREFRQmdvcWhraUc5Mk5rQmdJQkJBSVRBREFLQmdncWhrak9QUVFEQWdOSUFEQkZBaUVBdm56TWNWMjY4Y1JiMS9GcHlWMUVoVDNXRnZPenJCVVdQNi9Ub1RoRmF2TUNJRmJhNXQ2WUt5MFIySkR0eHF0T2pKeTY2bDZWN2QvUHJBRE5wa21JUFcraSIsIk1JSUJYRENDQVFJQ0NRQ2ZqVFVHTERuUjlqQUtCZ2dxaGtqT1BRUURBekEyTVFzd0NRWURWUVFHRXdKVlV6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVTTUJBR0ExVUVCd3dKUTNWd1pYSjBhVzV2TUI0WERUSXpNREV3TkRFMk1qQXpNbG9YRFRNek1ERXdNVEUyTWpBek1sb3dOakVMTUFrR0ExVUVCaE1DVlZNeEV6QVJCZ05WQkFnTUNrTmhiR2xtYjNKdWFXRXhFakFRQmdOVkJBY01DVU4xY0dWeWRHbHViekJaTUJNR0J5cUdTTTQ5QWdFR0NDcUdTTTQ5QXdFSEEwSUFCSFB2d1pmb0tMS2FPclgvV2U0cU9iWFNuYTVUZFdIVlo2aElSQTF3MG9jM1FDVDBJbzJwbHlEQjMvTVZsazJ0YzRLR0U4VGlxVzdpYlE2WmM5VjY0azB3Q2dZSUtvWkl6ajBFQXdNRFNBQXdSUUloQU1USGhXdGJBUU4waFN4SVhjUDRDS3JEQ0gvZ3N4V3B4NmpUWkxUZVorRlBBaUIzNW53azVxMHpjSXBlZnZZSjBNVS95R0dIU1dlejBicTBwRFlVTy9ubUR3PT0iXSwidHlwIjoiSldUIiwiYWxnIjoiRVMyNTYifQ.eyJlbnZpcm9ubWVudCI6IlNhbmRib3giLCJidW5kbGVJZCI6ImNvbS5leGFtcGxlIiwic2lnbmVkRGF0ZSI6MTY3Mjk1NjE1NDAwMH0.PnHWpeIJZ8f2Q218NSGLo_aR0IBEJvC6PxmxKXh-qfYTrZccx2suGl223OSNAX78e4Ylf2yJCG2N-FfU-NIhZQ";
    @Test
    public void testAppStoreServerNotificationDecoding() throws VerificationException {
        SignedDataVerifier verifier = getSignedPayloadVerifier();
        ResponseBodyV2DecodedPayload notification = verifier.verifyAndDecodeNotification(TEST_NOTIFICATION);
        Assertions.assertEquals(NotificationTypeV2.TEST, notification.getNotificationType());
    }

    @Test
    public void testMissingX5CHeader() {
        SignedDataVerifier verifier = getSignedPayloadVerifier();
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(MISSING_X5C_HEADER_CLAIM));
        Assertions.assertEquals(Status.VERIFICATION_FAILURE, exception.getStatus());
    }

    @Test
    public void testWrongBundleIdForServerNotification() {
        SignedDataVerifier verifier = getSignedPayloadVerifier();
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(WRONG_BUNDLE_ID));
        Assertions.assertEquals(Status.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    @Test
    public void testWrongBundleIdForTransaction() {
        SignedDataVerifier verifier = new SignedDataVerifier(Set.of(new ByteArrayInputStream(Base64.getDecoder().decode(ROOT_CA_BASE64_ENCODED))), "com.example.x", 1234L, Environment.SANDBOX, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeTransaction(TRANSACTION_INFO));
        Assertions.assertEquals(Status.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    @Test
    public void testWrongEnvironmentForServerNotification() {
        SignedDataVerifier verifier = new SignedDataVerifier(Set.of(new ByteArrayInputStream(Base64.getDecoder().decode(ROOT_CA_BASE64_ENCODED))), "com.example", 1234L, Environment.PRODUCTION, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(TEST_NOTIFICATION));
        Assertions.assertEquals(Status.INVALID_ENVIRONMENT, exception.getStatus());
    }

    @Test
    public void testRenewalInfoDecoding() throws VerificationException {
        SignedDataVerifier verifier = getSignedPayloadVerifier();
        JWSRenewalInfoDecodedPayload renewalInfo = verifier.verifyAndDecodeRenewalInfo(RENEWAL_INFO);
        Assertions.assertEquals(Environment.SANDBOX, renewalInfo.getEnvironment());
    }

    @Test
    public void testTransactionInfoDecoding() throws VerificationException {
        SignedDataVerifier verifier = getSignedPayloadVerifier();
        JWSTransactionDecodedPayload transaction = verifier.verifyAndDecodeTransaction(TRANSACTION_INFO);
        Assertions.assertEquals(Environment.SANDBOX, transaction.getEnvironment());
    }

    @Test
    public void testMalformedJWTWithTooManyParts() {
        SignedDataVerifier verifier = getSignedPayloadVerifier();
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification("a.b.c.d"));
        Assertions.assertEquals(Status.VERIFICATION_FAILURE, exception.getStatus());
    }

    @Test
    public void testMalformedJWTWithMalformedData() {
        SignedDataVerifier verifier = getSignedPayloadVerifier();
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification("a.b.c"));
        Assertions.assertEquals(Status.VERIFICATION_FAILURE, exception.getStatus());
    }

    private SignedDataVerifier getSignedPayloadVerifier() {
        return new SignedDataVerifier(Set.of(new ByteArrayInputStream(Base64.getDecoder().decode(ROOT_CA_BASE64_ENCODED))), "com.example", 1234L, Environment.SANDBOX, false);
    }
}
