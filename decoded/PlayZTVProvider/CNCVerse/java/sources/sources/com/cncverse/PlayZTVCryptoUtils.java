package com.cncverse;

import android.util.Base64;
import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayZTVCryptoUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayZTVProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/cncverse/PlayZTVCryptoUtils;", "", "<init>", "()V", "TAG", "", "NATIVE_KEY", "", "NATIVE_IV", "PRIMARY_KEY", "PRIMARY_IV", "FALLBACK_KEY", "FALLBACK_IV", "SUB_FROM", "SUB_TO", "SUB_REVERSE", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "decryptPlayZTV", "body", "decryptNativeLib", "raw", "swapAdjacentPairs", "b", "decryptPrimary", "decryptFallback", "normalizeBase64", "value", "aesCbcDecrypt", "cipherBytes", "key", "iv", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayZTVCryptoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVCryptoUtils.kt\ncom/cncverse/PlayZTVCryptoUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,228:1\n1#2:229\n*E\n"})
public final class PlayZTVCryptoUtils {

    @NotNull
    private static final String SUB_FROM = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";

    @NotNull
    private static final HashMap<Character, Character> SUB_REVERSE;

    @NotNull
    private static final String SUB_TO = "fFgGjJkKaApPbBmMoOzZeEnNcCdDrRqQtTvVuUxXhHiIwWyYlLsS";

    @NotNull
    private static final String TAG = "PlayZTVCrypto";

    @NotNull
    public static final PlayZTVCryptoUtils INSTANCE = new PlayZTVCryptoUtils();

    @NotNull
    private static final byte[] NATIVE_KEY = {99, 122, 49, 52, 82, 83, 116, 107, 78, 48, 49, 80, 86, 69, 53, 119};

    @NotNull
    private static final byte[] NATIVE_IV = {87, 84, 108, 69, 118, 99, 107, 100, 50, 85, 82, 52, 49, 115, 100, 107};

    @NotNull
    private static final byte[] PRIMARY_KEY = {98, 47, 49, 106, 109, 108, 53, 110, 107, 52, 120, 53, 107, 55, 112, 78};

    @NotNull
    private static final byte[] PRIMARY_IV = {49, 52, 110, 77, 107, 56, 109, 78, 53, 75, 108, 53, 75, 76, 55, 108};

    @NotNull
    private static final byte[] FALLBACK_KEY = {109, 53, 75, 108, 53, 110, 107, 52, 120, 75, 49, 107, 78, 55, 112, 78};

    @NotNull
    private static final byte[] FALLBACK_IV = {107, 53, 75, 52, 110, 77, 56, 109, 75, 108, 78, 76, 55, 108, 49, 53};

    private PlayZTVCryptoUtils() {
    }

    static {
        HashMap<Character, Character> map = new HashMap<>();
        int length = SUB_TO.length();
        for (int i = 0; i < length; i++) {
            map.put(Character.valueOf(SUB_TO.charAt(i)), Character.valueOf(SUB_FROM.charAt(i)));
        }
        SUB_REVERSE = map;
    }

    @Nullable
    public final String decryptPlayZTV(@Nullable String body) {
        String raw = body != null ? StringsKt.trim(body).toString() : null;
        if (raw == null) {
            raw = "";
        }
        if (raw.length() == 0) {
            Log.w(TAG, "Empty body");
            return null;
        }
        Log.d(TAG, "Raw payload: len=" + raw.length());
        if (StringsKt.startsWith$default(raw, "{", false, 2, (Object) null) || StringsKt.startsWith$default(raw, "[", false, 2, (Object) null) || StringsKt.startsWith$default(raw, "<", false, 2, (Object) null)) {
            return raw;
        }
        String it = decryptNativeLib(raw);
        if (it != null) {
            return it;
        }
        String it2 = decryptPrimary(raw);
        if (it2 != null) {
            return it2;
        }
        String it3 = decryptFallback(raw);
        if (it3 != null) {
            return it3;
        }
        Log.e(TAG, "All decryption strategies failed");
        return null;
    }

    private final String decryptNativeLib(String raw) {
        try {
            String stripped = new Regex("\\s").replace(raw, "");
            byte[] b1 = Base64.decode(stripped, 0);
            byte[] b1Reversed = ArraysKt.reversedArray(b1);
            byte[] b2 = swapAdjacentPairs(b1Reversed);
            String b2Str = new Regex("\\s").replace(new String(b2, Charsets.US_ASCII), "");
            byte[] b3 = Base64.decode(b2Str, 0);
            Log.d(TAG, "Native: B1=" + b1.length + "B rev=" + b1Reversed.length + "B B2=" + b2.length + "B B3=" + b3.length + 'B');
            byte[] pt = aesCbcDecrypt(b3, NATIVE_KEY, NATIVE_IV);
            if (pt == null) {
                return null;
            }
            String text = StringsKt.trim(new String(pt, Charsets.UTF_8)).toString();
            if (!StringsKt.startsWith$default(text, "{", false, 2, (Object) null) && !StringsKt.startsWith$default(text, "[", false, 2, (Object) null)) {
                return null;
            }
            Log.d(TAG, "Native decrypt success (" + pt.length + " bytes)");
            return text;
        } catch (Exception e) {
            Log.e(TAG, "Native decrypt failed: " + e.getMessage());
            return null;
        }
    }

    private final byte[] swapAdjacentPairs(byte[] b) {
        byte[] out = Arrays.copyOf(b, b.length);
        Intrinsics.checkNotNullExpressionValue(out, "copyOf(...)");
        for (int i = 0; i + 1 < out.length; i += 2) {
            byte tmp = out[i];
            out[i] = out[i + 1];
            out[i + 1] = tmp;
        }
        return out;
    }

    private final String decryptPrimary(String raw) {
        try {
            String stripped = new Regex("\\s").replace(raw, "");
            StringBuilder $this$decryptPrimary_u24lambda_u240 = new StringBuilder();
            int length = stripped.length();
            for (int i = 0; i < length; i++) {
                char c = stripped.charAt(i);
                Character ch = SUB_REVERSE.get(Character.valueOf(c));
                $this$decryptPrimary_u24lambda_u240.append(ch != null ? ch.charValue() : c);
            }
            String restored = $this$decryptPrimary_u24lambda_u240.toString();
            byte[] b1 = Base64.decode(normalizeBase64(restored), 0);
            String b1Str = new String(b1, Charsets.US_ASCII);
            byte[] ct = Base64.decode(normalizeBase64(b1Str), 0);
            byte[] pt = aesCbcDecrypt(ct, PRIMARY_KEY, PRIMARY_IV);
            if (pt == null) {
                return null;
            }
            String text = StringsKt.trim(new String(pt, Charsets.UTF_8)).toString();
            if (StringsKt.startsWith$default(text, "{", false, 2, (Object) null) || StringsKt.startsWith$default(text, "[", false, 2, (Object) null)) {
                return text;
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Primary decrypt failed: " + e.getMessage());
            return null;
        }
    }

    private final String decryptFallback(String raw) {
        try {
            String stripped = new Regex("\\s").replace(raw, "");
            byte[] ct = Base64.decode(normalizeBase64(stripped), 0);
            byte[] pt = aesCbcDecrypt(ct, FALLBACK_KEY, FALLBACK_IV);
            if (pt == null) {
                return null;
            }
            String text = StringsKt.trim(new String(pt, Charsets.UTF_8)).toString();
            if (StringsKt.startsWith$default(text, "{", false, 2, (Object) null) || StringsKt.startsWith$default(text, "[", false, 2, (Object) null)) {
                return text;
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Fallback decrypt failed: " + e.getMessage());
            return null;
        }
    }

    private final String normalizeBase64(String value) {
        String s = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(value, "-", "+", false, 4, (Object) null), "_", "/", false, 4, (Object) null), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null), " ", "", false, 4, (Object) null), "\t", "", false, 4, (Object) null);
        while (s.length() % 4 != 0) {
            s = s + '=';
        }
        return s;
    }

    private final byte[] aesCbcDecrypt(byte[] cipherBytes, byte[] key, byte[] iv) {
        if (key.length != 16 || iv.length != 16 || cipherBytes.length % 16 != 0) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            return cipher.doFinal(cipherBytes);
        } catch (Exception e) {
            Log.e(TAG, "AES failed: " + e.getMessage());
            return null;
        }
    }
}
