package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ8\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0002JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/phisher98/CryptoJS;", "", "<init>", "()V", "KEY_SIZE", "", "IV_SIZE", "HASH_CIPHER", "", CryptoJS.AES, "KDF_DIGEST", "APPEND", "encrypt", "password", "plainText", "decrypt", "cipherText", "EvpKDF", "", "keySize", "ivSize", "salt", "resultKey", "resultIv", "iterations", "hashAlgorithm", "generateSalt", "length", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class CryptoJS {

    @NotNull
    private static final String AES = "AES";

    @NotNull
    private static final String APPEND = "Salted__";

    @NotNull
    private static final String HASH_CIPHER = "AES/CBC/PKCS7Padding";

    @NotNull
    public static final CryptoJS INSTANCE = new CryptoJS();
    private static final int IV_SIZE = 128;

    @NotNull
    private static final String KDF_DIGEST = "MD5";
    private static final int KEY_SIZE = 256;

    private CryptoJS() {
    }

    @NotNull
    public final String encrypt(@NotNull String password, @NotNull String plainText) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] saltBytes = generateSalt(8);
        byte[] key = new byte[32];
        byte[] iv = new byte[16];
        byte[] bytes = password.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        EvpKDF(bytes, KEY_SIZE, IV_SIZE, saltBytes, key, iv);
        SecretKeySpec keyS = new SecretKeySpec(key, AES);
        Cipher cipher = Cipher.getInstance(HASH_CIPHER);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(1, keyS, ivSpec);
        byte[] bytes2 = plainText.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] cipherText = cipher.doFinal(bytes2);
        byte[] sBytes = APPEND.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(sBytes, "getBytes(...)");
        byte[] b = new byte[sBytes.length + saltBytes.length + cipherText.length];
        System.arraycopy(sBytes, 0, b, 0, sBytes.length);
        System.arraycopy(saltBytes, 0, b, sBytes.length, saltBytes.length);
        System.arraycopy(cipherText, 0, b, sBytes.length + saltBytes.length, cipherText.length);
        byte[] bEncode = StringsKt.encodeToByteArray(MainAPIKt.base64Encode(b));
        return new String(bEncode, Charsets.UTF_8);
    }

    @NotNull
    public final String decrypt(@NotNull String password, @NotNull String cipherText) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] ctBytes = MainAPIKt.base64DecodeArray(cipherText);
        byte[] saltBytes = Arrays.copyOfRange(ctBytes, 8, 16);
        byte[] cipherTextBytes = Arrays.copyOfRange(ctBytes, 16, ctBytes.length);
        byte[] key = new byte[32];
        byte[] iv = new byte[16];
        byte[] bytes = password.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        EvpKDF(bytes, KEY_SIZE, IV_SIZE, saltBytes, key, iv);
        Cipher cipher = Cipher.getInstance(HASH_CIPHER);
        SecretKeySpec keyS = new SecretKeySpec(key, AES);
        cipher.init(2, keyS, new IvParameterSpec(iv));
        byte[] plainText = cipher.doFinal(cipherTextBytes);
        return new String(plainText, Charsets.UTF_8);
    }

    private final byte[] EvpKDF(byte[] password, int keySize, int ivSize, byte[] salt, byte[] resultKey, byte[] resultIv) {
        return EvpKDF(password, keySize, ivSize, salt, 1, KDF_DIGEST, resultKey, resultIv);
    }

    private final byte[] EvpKDF(byte[] password, int keySize, int ivSize, byte[] salt, int iterations, String hashAlgorithm, byte[] resultKey, byte[] resultIv) throws NoSuchAlgorithmException {
        int keySize2 = keySize / 32;
        int ivSize2 = ivSize / 32;
        int targetKeySize = keySize2 + ivSize2;
        byte[] derivedBytes = new byte[targetKeySize * 4];
        byte[] block = null;
        MessageDigest hash = MessageDigest.getInstance(hashAlgorithm);
        for (int numberOfDerivedWords = 0; numberOfDerivedWords < targetKeySize; numberOfDerivedWords += block.length / 4) {
            if (block != null) {
                hash.update(block);
            }
            hash.update(password);
            block = hash.digest(salt);
            hash.reset();
            for (int i = 1; i < iterations; i++) {
                Intrinsics.checkNotNull(block);
                block = hash.digest(block);
                hash.reset();
            }
            Intrinsics.checkNotNull(block);
            System.arraycopy(block, 0, derivedBytes, numberOfDerivedWords * 4, Math.min(block.length, (targetKeySize - numberOfDerivedWords) * 4));
        }
        System.arraycopy(derivedBytes, 0, resultKey, 0, keySize2 * 4);
        System.arraycopy(derivedBytes, keySize2 * 4, resultIv, 0, ivSize2 * 4);
        return derivedBytes;
    }

    private final byte[] generateSalt(int length) {
        byte[] $this$generateSalt_u24lambda_u240 = new byte[length];
        new SecureRandom().nextBytes($this$generateSalt_u24lambda_u240);
        return $this$generateSalt_u24lambda_u240;
    }
}
