package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/phisher98/CryptoAES;", "", "<init>", "()V", "HASH_CIPHER", "", "HASH_CIPHER_FALLBACK", CryptoAES.AES, "decrypt", "cipherText", "keyBytes", "", "ivBytes", "decryptAES", "cipherTextBytes", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class CryptoAES {

    @NotNull
    private static final String AES = "AES";

    @NotNull
    private static final String HASH_CIPHER = "AES/CBC/PKCS7PADDING";

    @NotNull
    private static final String HASH_CIPHER_FALLBACK = "AES/CBC/PKCS5PADDING";

    @NotNull
    public static final CryptoAES INSTANCE = new CryptoAES();

    private CryptoAES() {
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
}
