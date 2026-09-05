package com.Kartoons;

import com.lagradost.cloudstream3.MainAPIKt;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003\"\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"base64UrlToBytes", "", "b64url", "", "deriveKeyBytes", "secret", "stripPkcs7Padding", "data", "decryptAesCbcBase64Url", "encryptedDataBase64Url", "STREAM_SECRET", "deriveKeySha256", "decryptStream", "value", "prefix", "Kartoons"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class UtilsKt {

    @NotNull
    private static final String STREAM_SECRET = MainAPIKt.base64Decode("cG1TMENBTUcxUnVxNDlXYk15aEUzZmgxc091TFlFTDlydEZhellZbGpWSTJqNEJQU29nNzNoVzdBN3hNaGNlSEQwaXdyUHJWVkRYTHZ4eVdy");

    @NotNull
    public static final byte[] base64UrlToBytes(@NotNull String b64url) {
        String s = StringsKt.replace$default(StringsKt.replace$default(b64url, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
        int pad = s.length() % 4;
        if (pad != 0) {
            s = s + StringsKt.repeat("=", 4 - pad);
        }
        return MainAPIKt.base64DecodeArray(s);
    }

    @NotNull
    public static final byte[] deriveKeyBytes(@NotNull String secret) {
        String fixed = StringsKt.padEnd(secret, 32, ' ').substring(0, 32);
        Intrinsics.checkNotNullExpressionValue(fixed, "substring(...)");
        byte[] bytes = fixed.getBytes(StandardCharsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @NotNull
    public static final byte[] stripPkcs7Padding(@NotNull byte[] data) {
        boolean z = false;
        if (data.length == 0) {
            return data;
        }
        int padValue = ArraysKt.last(data) & 255;
        if (1 <= padValue && padValue < 17) {
            z = true;
        }
        if (!z) {
            return data;
        }
        for (int i = 0; i < padValue; i++) {
            int b = data[(data.length - 1) - i] & 255;
            if (b != padValue) {
                return data;
            }
        }
        int i2 = data.length;
        byte[] bArrCopyOf = Arrays.copyOf(data, i2 - padValue);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @NotNull
    public static final String decryptAesCbcBase64Url(@NotNull String encryptedDataBase64Url) throws Exception {
        String secretKeyString = MainAPIKt.base64Decode("YmNhOWUwZGYxYTVhYmIzMjkwNmNhM2Y2M2FjMDRjZWY=");
        if (!(encryptedDataBase64Url.length() == 0)) {
            if (!(secretKeyString.length() == 0)) {
                byte[] keyBytes = deriveKeyBytes(secretKeyString);
                if (keyBytes.length != 32) {
                    throw new IllegalArgumentException("Key length " + keyBytes.length + " != 32 bytes");
                }
                byte[] encryptedBytes = base64UrlToBytes(encryptedDataBase64Url);
                if (encryptedBytes.length <= 16) {
                    throw new IllegalArgumentException("Ciphertext too short: missing IV or data");
                }
                byte[] iv = ArraysKt.copyOfRange(encryptedBytes, 0, 16);
                byte[] ciphertext = ArraysKt.copyOfRange(encryptedBytes, 16, encryptedBytes.length);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(iv);
                cipher.init(2, keySpec, ivSpec);
                byte[] paddedPlaintext = cipher.doFinal(ciphertext);
                byte[] plaintextBytes = stripPkcs7Padding(paddedPlaintext);
                return new String(plaintextBytes, StandardCharsets.UTF_8);
            }
        }
        throw new IllegalArgumentException("encrypted data and secret key must be provided");
    }

    private static final byte[] deriveKeySha256() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = STREAM_SECRET.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return digest.digest(bytes);
    }

    public static /* synthetic */ String decryptStream$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "enc2:";
        }
        return decryptStream(str, str2);
    }

    @Nullable
    public static final String decryptStream(@Nullable String value, @NotNull String prefix) {
        String str = value;
        if (str == null || str.length() == 0) {
            System.out.println((Object) "Error: empty input");
            return null;
        }
        if (!StringsKt.startsWith$default(value, prefix, false, 2, (Object) null)) {
            return value;
        }
        try {
            String rawB64url = value.substring(prefix.length());
            Intrinsics.checkNotNullExpressionValue(rawB64url, "substring(...)");
            byte[] blob = base64UrlToBytes(rawB64url);
            if (blob.length <= 12) {
                throw new IllegalArgumentException("Ciphertext too short: need 12-byte IV + data");
            }
            byte[] iv = ArraysKt.copyOfRange(blob, 0, 12);
            byte[] ctAndTag = ArraysKt.copyOfRange(blob, 12, blob.length);
            byte[] keyBytes = deriveKeySha256();
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
            cipher.init(2, keySpec, gcmSpec);
            byte[] plainBytes = cipher.doFinal(ctAndTag);
            return StringsKt.trim(new String(plainBytes, Charsets.UTF_8)).toString();
        } catch (Exception e) {
            System.out.println((Object) ("Decryption failed: " + e.getMessage()));
            return null;
        }
    }
}
