package com.cncverse;

import android.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SKLiveCryptoUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SKTechProvider/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/cncverse/SKLiveCryptoUtils;", "", "<init>", "()V", "V25_KEY1", "", "V25_KEY2", "V25_IV", "V23_KEY", "V23_IV", "LEGACY_AES_KEY", "LEGACY_AES_IV", "FALLBACK_AES_KEY", "FALLBACK_AES_IV", "LOOKUP_TABLE_D", "", "hexStringToByteArray", "hex", "padBase64", "s", "aesDecryptAndTransform", "ciphertext", "key", "iv", "prepareCiphertext", "encryptedData", "decryptV25Pass1", "decryptV25Pass2", "decryptV23", "decryptLegacy", "customToStandardBase64", "customB64", "decryptFallbackB", "decryptFallbackC", "preprocessResponse", "rawResponse", "decryptSKLive", "SKTechProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSKLiveCryptoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SKLiveCryptoUtils.kt\ncom/cncverse/SKLiveCryptoUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n1#2:251\n*E\n"})
public final class SKLiveCryptoUtils {

    @NotNull
    private static final byte[] FALLBACK_AES_IV;

    @NotNull
    private static final byte[] FALLBACK_AES_KEY;

    @NotNull
    public static final SKLiveCryptoUtils INSTANCE = new SKLiveCryptoUtils();

    @NotNull
    private static final byte[] LEGACY_AES_IV;

    @NotNull
    private static final byte[] LEGACY_AES_KEY;

    @NotNull
    private static final String LOOKUP_TABLE_D;

    @NotNull
    private static final byte[] V23_IV;

    @NotNull
    private static final byte[] V23_KEY;

    @NotNull
    private static final byte[] V25_IV;

    @NotNull
    private static final byte[] V25_KEY1;

    @NotNull
    private static final byte[] V25_KEY2;

    private SKLiveCryptoUtils() {
    }

    static {
        byte[] bytes = "V9LQR42pNKc7smaX".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        V25_KEY1 = bytes;
        byte[] bytes2 = "d2WT1lR4ckEvUsdk".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        V25_KEY2 = bytes2;
        byte[] bytes3 = "I=4dkwPiOuROD+pD".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        V25_IV = bytes3;
        byte[] bytes4 = "ST00ZGt3UGlPdVJP".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
        V23_KEY = bytes4;
        byte[] bytes5 = "d2WT1lR4ckEvUsdk".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes5, "getBytes(...)");
        V23_IV = bytes5;
        LEGACY_AES_KEY = INSTANCE.hexStringToByteArray("6c326c356b4237784335715031724b31");
        LEGACY_AES_IV = INSTANCE.hexStringToByteArray("70314b356e50377542386848316c3139");
        byte[] bytes6 = "l2l5kB7xC5qP1rK1".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes6, "getBytes(...)");
        FALLBACK_AES_KEY = bytes6;
        byte[] bytes7 = "p1K5nP7uB8hH1l19".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes7, "getBytes(...)");
        FALLBACK_AES_IV = bytes7;
        LOOKUP_TABLE_D = "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@EGMNKABUVCDYHLIFPOZQSRWTXJ[\\]^_`egmnkabuvcdyhlifpozqsrwtxj{|}~\u007f";
    }

    private final byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, len), 2);
        int i = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
            while (true) {
                data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
                if (i == last) {
                    break;
                }
                i += step;
            }
        }
        return data;
    }

    private final String padBase64(String s) {
        return s.length() % 4 != 0 ? s + StringsKt.repeat("=", 4 - (s.length() % 4)) : s;
    }

    private final byte[] aesDecryptAndTransform(byte[] ciphertext, byte[] key, byte[] iv) {
        try {
            if (ciphertext.length % 16 != 0) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            List plain = ArraysKt.toMutableList(cipher.doFinal(ciphertext));
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, plain.size() - 1), 2);
            int i = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
                while (true) {
                    byte tmp = ((Number) plain.get(i)).byteValue();
                    plain.set(i, plain.get(i + 1));
                    plain.set(i + 1, Byte.valueOf(tmp));
                    if (i == last) {
                        break;
                    }
                    i += step;
                }
            }
            CollectionsKt.reverse(plain);
            return CollectionsKt.toByteArray(plain);
        } catch (Exception e) {
            return null;
        }
    }

    private final byte[] prepareCiphertext(String encryptedData) {
        String src;
        if (StringsKt.startsWith$default(encryptedData, "==", false, 2, (Object) null)) {
            src = StringsKt.reversed(encryptedData).toString();
        } else {
            src = encryptedData;
        }
        try {
            byte[] decoded = Base64.decode(padBase64(src), 0);
            if (decoded.length > 12 && decoded.length % 16 == 12) {
                return ArraysKt.copyOfRange(decoded, 12, decoded.length);
            }
            if (decoded.length % 16 == 0) {
                return decoded;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final String decryptV25Pass1(String encryptedData) {
        byte[] plain;
        byte[] ciphertext = prepareCiphertext(encryptedData);
        if (ciphertext == null || (plain = aesDecryptAndTransform(ciphertext, V23_KEY, V25_KEY1)) == null) {
            return null;
        }
        boolean z = false;
        try {
            byte[] decodedFinal = Base64.decode(plain, 0);
            String s = new String(decodedFinal, Charsets.UTF_8);
            Character chFirstOrNull = StringsKt.firstOrNull(StringsKt.trimStart(s).toString());
            if (chFirstOrNull != null) {
                char it = chFirstOrNull.charValue();
                if (((it == '[' || it == '{') ? (char) 1 : (char) 0) == 1) {
                    z = true;
                }
            }
            if (z) {
                return s;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final String decryptV25Pass2(String encryptedData) {
        byte[] plain;
        byte[] ciphertext = prepareCiphertext(encryptedData);
        if (ciphertext == null || (plain = aesDecryptAndTransform(ciphertext, V23_KEY, V25_KEY2)) == null) {
            return null;
        }
        boolean z = false;
        try {
            byte[] decodedFinal = Base64.decode(plain, 0);
            String s = new String(decodedFinal, Charsets.UTF_8);
            Character chFirstOrNull = StringsKt.firstOrNull(StringsKt.trimStart(s).toString());
            if (chFirstOrNull != null) {
                char it = chFirstOrNull.charValue();
                if (((it == '[' || it == '{') ? (char) 1 : (char) 0) == 1) {
                    z = true;
                }
            }
            if (z) {
                return s;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final String decryptV23(String encryptedData) {
        try {
            boolean z = false;
            List inner = ArraysKt.toMutableList(Base64.decode(padBase64(encryptedData), 0));
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, inner.size() - 1), 2);
            int i = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
                while (true) {
                    byte tmp = ((Number) inner.get(i)).byteValue();
                    inner.set(i, inner.get(i + 1));
                    inner.set(i + 1, Byte.valueOf(tmp));
                    if (i == last) {
                        break;
                    }
                    i += step;
                }
            }
            CollectionsKt.reverse(inner);
            byte[] ciphertext = Base64.decode(CollectionsKt.toByteArray(inner), 0);
            if (ciphertext.length % 16 != 0) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(V23_KEY, "AES"), new IvParameterSpec(V23_IV));
            byte[] plaintext = cipher.doFinal(ciphertext);
            String s = new String(plaintext, Charsets.UTF_8);
            Character chFirstOrNull = StringsKt.firstOrNull(StringsKt.trimStart(s).toString());
            if (chFirstOrNull != null) {
                char it = chFirstOrNull.charValue();
                if (((it == '[' || it == '{') ? (char) 1 : (char) 0) == 1) {
                    z = true;
                }
            }
            if (z) {
                return s;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final String decryptLegacy(String encryptedData) {
        try {
            String standardB64 = customToStandardBase64(encryptedData);
            byte[] ciphertext = Base64.decode(standardB64, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(LEGACY_AES_KEY, "AES"), new IvParameterSpec(LEGACY_AES_IV));
            byte[] decrypted = cipher.doFinal(ciphertext);
            return new String(decrypted, Charsets.UTF_8);
        } catch (Exception e) {
            System.out.println((Object) ("[ERROR] Legacy decryption failed: " + e.getMessage()));
            return null;
        }
    }

    private final String customToStandardBase64(String customB64) {
        StringBuilder result = new StringBuilder();
        int length = customB64.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = customB64.charAt(i);
            if (cCharAt < LOOKUP_TABLE_D.length()) {
                result.append(LOOKUP_TABLE_D.charAt(cCharAt));
            } else {
                result.append(cCharAt);
            }
        }
        return result.toString();
    }

    private final String decryptFallbackB(String encryptedData) {
        try {
            String standardB64 = customToStandardBase64(encryptedData);
            boolean z = false;
            byte[] decodedBytes = Base64.decode(padBase64(standardB64), 0);
            String step1 = new String(decodedBytes, Charsets.UTF_8);
            String step2 = StringsKt.reversed(step1).toString();
            byte[] step3Raw = Base64.decode(padBase64(step2), 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(FALLBACK_AES_KEY, "AES"), new IvParameterSpec(FALLBACK_AES_IV));
            byte[] decrypted = cipher.doFinal(step3Raw);
            String result = new String(decrypted, Charsets.UTF_8);
            Character chFirstOrNull = StringsKt.firstOrNull(StringsKt.trimStart(result).toString());
            if (chFirstOrNull != null) {
                char it = chFirstOrNull.charValue();
                if (((it == '[' || it == '{') ? (char) 1 : (char) 0) == 1) {
                    z = true;
                }
            }
            if (z) {
                return result;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final String decryptFallbackC(String encryptedData) {
        try {
            boolean z = false;
            byte[] raw = Base64.decode(padBase64(encryptedData), 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(FALLBACK_AES_KEY, "AES"), new IvParameterSpec(FALLBACK_AES_IV));
            byte[] decrypted = cipher.doFinal(raw);
            String result = new String(decrypted, Charsets.UTF_8);
            Character chFirstOrNull = StringsKt.firstOrNull(StringsKt.trimStart(result).toString());
            if (chFirstOrNull != null) {
                char it = chFirstOrNull.charValue();
                if (((it == '[' || it == '{') ? (char) 1 : (char) 0) == 1) {
                    z = true;
                }
            }
            if (z) {
                return result;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final String preprocessResponse(String rawResponse) {
        try {
            char[] charArray = rawResponse.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, charArray.length - 1), 2);
            int i = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
                while (true) {
                    char temp = charArray[i];
                    charArray[i] = charArray[i + 1];
                    charArray[i + 1] = temp;
                    if (i == last) {
                        break;
                    }
                    i += step;
                }
            }
            String reversed = StringsKt.reversed(new String(charArray)).toString();
            byte[] decodedBytes = Base64.decode(reversed, 0);
            String str2 = new String(decodedBytes, Charsets.UTF_8);
            if (!StringsKt.endsWith$default(str2, "BA@GBA@GBA@GBA@G", false, 2, (Object) null)) {
                return null;
            }
            String strSubstring = str2.substring(0, str2.length() - "BA@GBA@GBA@GBA@G".length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public final String decryptSKLive(@NotNull String encryptedData) {
        String legacyInput;
        String it;
        String preprocessed = preprocessResponse(encryptedData);
        String v25Input = preprocessed == null ? encryptedData : preprocessed;
        String it2 = decryptV25Pass1(v25Input);
        if (it2 != null) {
            return it2;
        }
        String it3 = decryptV25Pass2(v25Input);
        if (it3 != null) {
            return it3;
        }
        String it4 = decryptV23(encryptedData);
        if (it4 != null) {
            return it4;
        }
        String it5 = decryptLegacy(v25Input);
        if (it5 != null) {
            return it5;
        }
        try {
            legacyInput = new String(Base64.decode(encryptedData, 0), Charsets.UTF_8);
        } catch (Exception e) {
            legacyInput = encryptedData;
        }
        String it6 = decryptLegacy(legacyInput);
        if (it6 != null) {
            System.out.println((Object) ("SKLiveCrypto: ✓ decryptLegacy (Base64-unwrapped) succeeded (" + it6.length() + " chars)"));
            return it6;
        }
        if (!Intrinsics.areEqual(legacyInput, encryptedData) && (it = decryptLegacy(encryptedData)) != null) {
            System.out.println((Object) ("SKLiveCrypto: ✓ decryptLegacy (raw) succeeded (" + it.length() + " chars)"));
            return it;
        }
        String it7 = decryptFallbackB(encryptedData);
        if (it7 != null) {
            System.out.println((Object) ("SKLiveCrypto: ✓ decryptFallbackB succeeded (" + it7.length() + " chars)"));
            return it7;
        }
        String it8 = decryptFallbackC(encryptedData);
        if (it8 != null) {
            System.out.println((Object) ("SKLiveCrypto: ✓ decryptFallbackC succeeded (" + it8.length() + " chars)"));
            return it8;
        }
        return null;
    }
}
