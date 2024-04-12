// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.IOException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;

public class SignedDataCreator {

    public static String createSignedDataFromJson(String path) throws IOException, NoSuchAlgorithmException {
        String json = TestingUtility.readFile(path);
        KeyPairGenerator ec = KeyPairGenerator.getInstance("EC");
        ec.initialize(256);
        return JWT.create()
                .withPayload(json)
                .sign(Algorithm.ECDSA256((ECPrivateKey) ec.generateKeyPair().getPrivate()));
    }
}
