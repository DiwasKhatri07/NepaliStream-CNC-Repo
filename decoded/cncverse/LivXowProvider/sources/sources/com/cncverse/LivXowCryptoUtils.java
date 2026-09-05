package com.cncverse;

import android.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LivXowCryptoUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/LivXowProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/cncverse/LivXowCryptoUtils;", "", "<init>", "()V", "STANDARD_ALPHABET", "", "SHUFFLED_ALPHABET", "decodeTable", "", "AES_KEY", "", "AES_IV", "decryptSubstitution", "str", "decryptHttpResponse", "decrypt", "hexToBase64Unpadded", "hex", "makeClearKeyJson", "api", "LivXowProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLivXowCryptoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivXowCryptoUtils.kt\ncom/cncverse/LivXowCryptoUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1#2:128\n*E\n"})
public final class LivXowCryptoUtils {

    @NotNull
    private static final byte[] AES_IV;

    @NotNull
    private static final byte[] AES_KEY;

    @NotNull
    public static final LivXowCryptoUtils INSTANCE = new LivXowCryptoUtils();

    @NotNull
    private static final String SHUFFLED_ALPHABET = "fFgGjJkKaApPbBmMoOzZeEnNcCdDrRqQtTvVuUxXhHiIwWyYlLsS";

    @NotNull
    private static final String STANDARD_ALPHABET = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";

    @NotNull
    private static final char[] decodeTable;

    private LivXowCryptoUtils() {
    }

    static {
        char[] table = new char[128];
        for (int i = 0; i < 128; i++) {
            table[i] = (char) i;
        }
        int length = STANDARD_ALPHABET.length();
        for (int i2 = 0; i2 < length; i2++) {
            table[SHUFFLED_ALPHABET.charAt(i2)] = STANDARD_ALPHABET.charAt(i2);
        }
        decodeTable = table;
        byte[] bytes = "M8mkKlNL75K4nl15".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        AES_KEY = bytes;
        byte[] bytes2 = "kN7m5Kl1pN5nk4xK".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        AES_IV = bytes2;
    }

    private final String decryptSubstitution(String str) {
        int length = str.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            int c = str.charAt(i);
            chars[i] = c >= 0 && c < 128 ? decodeTable[c] : str.charAt(i);
        }
        return new String(chars);
    }

    @NotNull
    public final String decryptHttpResponse(@NotNull String str) {
        String padded;
        if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null) || StringsKt.startsWith$default(str, "[", false, 2, (Object) null)) {
            return str;
        }
        try {
            String substituted = decryptSubstitution(str);
            if (substituted.length() % 4 != 0) {
                padded = substituted + StringsKt.repeat("=", 4 - (substituted.length() % 4));
            } else {
                padded = substituted;
            }
            byte[] decoded = Base64.decode(padded, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(AES_KEY, "AES"), new IvParameterSpec(AES_IV));
            return new String(cipher.doFinal(decoded), Charsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    @Nullable
    public final String decrypt(@NotNull String str) {
        String strDecryptHttpResponse = decryptHttpResponse(str);
        if (StringsKt.isBlank(strDecryptHttpResponse)) {
            strDecryptHttpResponse = null;
        }
        return strDecryptHttpResponse;
    }

    @NotNull
    public final String hexToBase64Unpadded(@NotNull String hex) {
        String clean = StringsKt.replace$default(StringsKt.replace$default(hex, "-", "", false, 4, (Object) null), " ", "", false, 4, (Object) null);
        int length = clean.length() / 2;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String strSubstring = clean.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            bytes[i] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
        }
        return Base64.encodeToString(bytes, 11);
    }

    @NotNull
    public final String makeClearKeyJson(@NotNull String api) {
        List parts = StringsKt.split$default(api, new String[]{":"}, false, 0, 6, (Object) null);
        if (parts.size() < 2) {
            return "";
        }
        String kid = hexToBase64Unpadded(StringsKt.trim((String) parts.get(0)).toString());
        String key = hexToBase64Unpadded(StringsKt.trim((String) parts.get(1)).toString());
        return "{\"keys\":[{\"kty\":\"oct\",\"k\":\"" + key + "\",\"kid\":\"" + kid + "\"}],\"type\":\"temporary\"}";
    }
}
