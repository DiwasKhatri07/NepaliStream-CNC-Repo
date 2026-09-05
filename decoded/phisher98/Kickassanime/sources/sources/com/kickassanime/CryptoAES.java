package com.kickassanime;

import com.lagradost.cloudstream3.MainAPIKt;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Crypto.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kickassanime/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002JG\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010\"J\n\u0010#\u001a\u00020\u0013*\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/kickassanime/CryptoAES;", "", "<init>", "()V", "KEY_SIZE", "", "IV_SIZE", "SALT_SIZE", "HASH_CIPHER", "", "HASH_CIPHER_FALLBACK", CryptoAES.AES, "KDF_DIGEST", "decrypt", "cipherText", "password", "decryptWithSalt", "salt", "keyBytes", "", "ivBytes", "encrypt", "plainText", "decryptAES", "cipherTextBytes", "encryptAES", "plainTextBytes", "generateKeyAndIV", "", "keyLength", "ivLength", "iterations", "md", "Ljava/security/MessageDigest;", "(III[B[BLjava/security/MessageDigest;)[[B", "decodeHex", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrypto.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Crypto.kt\ncom/kickassanime/CryptoAES\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,220:1\n1#2:221\n1739#3:222\n1814#3,3:223\n*S KotlinDebug\n*F\n+ 1 Crypto.kt\ncom/kickassanime/CryptoAES\n*L\n217#1:222\n217#1:223,3\n*E\n"})
public final class CryptoAES {

    @NotNull
    private static final String AES = "AES";

    @NotNull
    private static final String HASH_CIPHER = "AES/CBC/PKCS7PADDING";

    @NotNull
    private static final String HASH_CIPHER_FALLBACK = "AES/CBC/PKCS5PADDING";

    @NotNull
    public static final CryptoAES INSTANCE = new CryptoAES();
    private static final int IV_SIZE = 16;

    @NotNull
    private static final String KDF_DIGEST = "MD5";
    private static final int KEY_SIZE = 32;
    private static final int SALT_SIZE = 8;

    private CryptoAES() {
    }

    @NotNull
    public final String decrypt(@NotNull String cipherText, @NotNull String password) {
        byte[] bArr;
        byte[] bArr2;
        try {
            byte[] ctBytes = MainAPIKt.base64DecodeArray(cipherText);
            byte[] saltBytes = Arrays.copyOfRange(ctBytes, SALT_SIZE, IV_SIZE);
            byte[] cipherTextBytes = Arrays.copyOfRange(ctBytes, IV_SIZE, ctBytes.length);
            MessageDigest md5 = MessageDigest.getInstance(KDF_DIGEST);
            byte[] bytes = password.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[][] keyAndIV = generateKeyAndIV(KEY_SIZE, IV_SIZE, 1, saltBytes, bytes, md5);
            if (keyAndIV == null || (bArr = keyAndIV[0]) == null) {
                bArr = new byte[KEY_SIZE];
            }
            if (keyAndIV == null || (bArr2 = keyAndIV[1]) == null) {
                bArr2 = new byte[IV_SIZE];
            }
            return decryptAES(cipherTextBytes, bArr, bArr2);
        } catch (Exception e) {
            return "";
        }
    }

    @NotNull
    public final String decryptWithSalt(@NotNull String cipherText, @NotNull String salt, @NotNull String password) {
        byte[] bArr;
        byte[] bArr2;
        try {
            byte[] ctBytes = MainAPIKt.base64DecodeArray(cipherText);
            MessageDigest md5 = MessageDigest.getInstance(KDF_DIGEST);
            byte[] bArrDecodeHex = decodeHex(salt);
            byte[] bytes = password.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[][] keyAndIV = generateKeyAndIV(KEY_SIZE, IV_SIZE, 1, bArrDecodeHex, bytes, md5);
            if (keyAndIV == null || (bArr = keyAndIV[0]) == null) {
                bArr = new byte[KEY_SIZE];
            }
            if (keyAndIV == null || (bArr2 = keyAndIV[1]) == null) {
                bArr2 = new byte[IV_SIZE];
            }
            return decryptAES(ctBytes, bArr, bArr2);
        } catch (Exception e) {
            return "";
        }
    }

    @NotNull
    public final String decrypt(@NotNull String cipherText, @NotNull byte[] keyBytes, @NotNull byte[] ivBytes) {
        try {
            byte[] cipherTextBytes = MainAPIKt.base64DecodeArray(cipherText);
            return decryptAES(cipherTextBytes, keyBytes, ivBytes);
        } catch (Exception e) {
            return "";
        }
    }

    @NotNull
    public final String encrypt(@NotNull String plainText, @NotNull byte[] keyBytes, @NotNull byte[] ivBytes) {
        try {
            byte[] cipherTextBytes = plainText.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(cipherTextBytes, "getBytes(...)");
            return encryptAES(cipherTextBytes, keyBytes, ivBytes);
        } catch (Exception e) {
            return "";
        }
    }

    private final String decryptAES(byte[] cipherTextBytes, byte[] keyBytes, byte[] ivBytes) {
        Cipher cipher;
        try {
            try {
                cipher = Cipher.getInstance(HASH_CIPHER);
            } catch (Throwable th) {
                cipher = Cipher.getInstance(HASH_CIPHER_FALLBACK);
            }
            SecretKeySpec keyS = new SecretKeySpec(keyBytes, AES);
            cipher.init(2, keyS, new IvParameterSpec(ivBytes));
            return new String(cipher.doFinal(cipherTextBytes), Charsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    private final String encryptAES(byte[] plainTextBytes, byte[] keyBytes, byte[] ivBytes) {
        Cipher cipher;
        try {
            try {
                cipher = Cipher.getInstance(HASH_CIPHER);
            } catch (Throwable th) {
                cipher = Cipher.getInstance(HASH_CIPHER_FALLBACK);
            }
            SecretKeySpec keyS = new SecretKeySpec(keyBytes, AES);
            cipher.init(1, keyS, new IvParameterSpec(ivBytes));
            return MainAPIKt.base64Encode(cipher.doFinal(plainTextBytes));
        } catch (Exception e) {
            return "";
        }
    }

    private final byte[][] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {
        int digestLength = md.getDigestLength();
        int requiredLength = ((((keyLength + ivLength) + digestLength) - 1) / digestLength) * digestLength;
        byte[] generatedData = new byte[requiredLength];
        try {
            try {
                md.reset();
                for (int generatedLength = 0; generatedLength < keyLength + ivLength; generatedLength += digestLength) {
                    if (generatedLength > 0) {
                        md.update(generatedData, generatedLength - digestLength, digestLength);
                    }
                    md.update(password);
                    md.update(salt, 0, SALT_SIZE);
                    md.digest(generatedData, generatedLength, digestLength);
                    for (int i = 1; i < iterations; i++) {
                        md.update(generatedData, generatedLength, digestLength);
                        md.digest(generatedData, generatedLength, digestLength);
                    }
                }
                byte[][] result = new byte[2][];
                result[0] = ArraysKt.copyOfRange(generatedData, 0, keyLength);
                if (ivLength > 0) {
                    result[1] = ArraysKt.copyOfRange(generatedData, keyLength, keyLength + ivLength);
                }
                Arrays.fill(generatedData, (byte) 0);
                return result;
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            Arrays.fill(generatedData, (byte) 0);
            throw th;
        }
    }

    @NotNull
    public final byte[] decodeHex(@NotNull String $this$decodeHex) {
        if (!($this$decodeHex.length() % 2 == 0)) {
            throw new IllegalStateException("Must have an even length".toString());
        }
        Iterable $this$map$iv = StringsKt.chunked($this$decodeHex, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(IV_SIZE))));
        }
        return CollectionsKt.toByteArray((List) destination$iv$iv);
    }
}
