package com.IStreamFlare;

import com.lagradost.cloudstream3.MainAPIKt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"SECRET_KEY", "", "SALT", "decryptPayload", "encryptedBase64", "deriveKey", "Ljavax/crypto/SecretKey;", "IStreamFlare"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIStreamFlareParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IStreamFlareParser.kt\ncom/IStreamFlare/IStreamFlareParserKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,171:1\n1#2:172\n*E\n"})
public final class IStreamFlareParserKt {

    @NotNull
    private static final String SALT = "iStreamFlareSalt";

    @NotNull
    private static final String SECRET_KEY = MainAPIKt.base64Decode("aVNmIzIwMjQkWGs5QG1OcFFyU3RVdld4WXoxMjM0QWI=");

    @NotNull
    public static final String decryptPayload(@NotNull String encryptedBase64) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] decoded = MainAPIKt.base64DecodeArray(encryptedBase64);
        if (!(decoded.length >= 28)) {
            throw new IllegalArgumentException("Invalid encrypted payload".toString());
        }
        byte[] iv = ArraysKt.copyOfRange(decoded, 0, 12);
        byte[] tag = ArraysKt.copyOfRange(decoded, 12, 28);
        byte[] ciphertext = ArraysKt.copyOfRange(decoded, 28, decoded.length);
        SecretKey key = deriveKey();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, key, new GCMParameterSpec(128, iv));
        byte[] plaintext = cipher.doFinal(ArraysKt.plus(ciphertext, tag));
        return new String(plaintext, Charsets.UTF_8);
    }

    private static final SecretKey deriveKey() throws NoSuchAlgorithmException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        char[] charArray = SECRET_KEY.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        byte[] bytes = SALT.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        PBEKeySpec spec = new PBEKeySpec(charArray, bytes, 10000, 256);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }
}
