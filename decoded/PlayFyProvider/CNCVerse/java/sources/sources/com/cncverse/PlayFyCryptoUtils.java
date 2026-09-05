package com.cncverse;

import android.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayFyCryptoUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayFyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J$\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u001e\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010$2\u0006\u0010%\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/cncverse/PlayFyCryptoUtils;", "", "<init>", "()V", "DEFAULT_LORA", "", "DEFAULT_SIG", "FALLBACK_KEY", "", "FALLBACK_IV", "FNV32_PRIME", "", "MASK32", "fnv1a32", "data", "seed", "s32", "v", "u32", "deriveKey", "lora", "sig", "deriveIv", "decodeBase64", "encoded", "pkcs7Unpad", "aesCbcDecrypt", "ct", "key", "iv", "isValidUtf8", "", "decryptPlayFy", "extractDataField", "responseText", "parseJsonToMap", "", "json", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayFyCryptoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFyCryptoUtils.kt\ncom/cncverse/PlayFyCryptoUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,188:1\n1786#2,3:189\n63#3:192\n64#3,15:194\n1#4:193\n50#5:209\n43#5:210\n*S KotlinDebug\n*F\n+ 1 PlayFyCryptoUtils.kt\ncom/cncverse/PlayFyCryptoUtils\n*L\n108#1:189,3\n182#1:192\n182#1:194,15\n182#1:193\n182#1:209\n182#1:210\n*E\n"})
public final class PlayFyCryptoUtils {

    @NotNull
    public static final String DEFAULT_LORA = "zH7hY9@lO=8uXk#f%mI/VvJd2G10Z5eU+L6Pi&aEbwA4scBCStQ3KyWqRjDgnoMRP";

    @NotNull
    public static final String DEFAULT_SIG = "Mc1pOdG+rjLRsO8tlGCxcBFqGIU";

    @NotNull
    private static final byte[] FALLBACK_IV;

    @NotNull
    private static final byte[] FALLBACK_KEY;
    private static final long FNV32_PRIME = 16777619;

    @NotNull
    public static final PlayFyCryptoUtils INSTANCE = new PlayFyCryptoUtils();
    private static final long MASK32 = 4294967295L;

    private PlayFyCryptoUtils() {
    }

    static {
        byte[] bytes = "ouAzyvGQqd5yAi5G".getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        FALLBACK_KEY = bytes;
        byte[] bytes2 = "QC4a1NX)XXEHq1bf".getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        FALLBACK_IV = bytes2;
    }

    private final long fnv1a32(byte[] data, long seed) {
        long h = seed & MASK32;
        for (byte b : data) {
            h = (((((long) b) & 255) ^ h) * FNV32_PRIME) & MASK32;
        }
        return h;
    }

    private final long s32(long v) {
        long u = MASK32 & v;
        return u >= 2147483648L ? u - 4294967296L : u;
    }

    private final long u32(long v) {
        return MASK32 & v;
    }

    private final byte[] deriveKey(String lora, String sig) {
        String str = sig;
        byte[] sigBytes = str.getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(sigBytes, "getBytes(...)");
        int sigLen = str.length();
        int loraLen = lora.length();
        long h = fnv1a32(sigBytes, 2166136261L);
        byte[] key = new byte[16];
        long offset = 0;
        int i = 0;
        for (int i2 = 16; i < i2; i2 = 16) {
            int idx = i % sigLen;
            long charVal = s32(str.charAt(idx));
            byte[] key2 = key;
            long product = s32(h) * 31;
            long mixed = u32(s32(charVal + offset) ^ s32(product));
            h = mixed;
            long mixed2 = loraLen;
            key2[i] = (byte) lora.charAt((int) (h % mixed2));
            offset = u32(((long) 13) + offset);
            i++;
            str = sig;
            sigBytes = sigBytes;
            key = key2;
        }
        return key;
    }

    private final byte[] deriveIv(String lora, String sig) {
        String str = sig;
        byte[] sigBytes = str.getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(sigBytes, "getBytes(...)");
        int sigLen = str.length();
        int loraLen = lora.length();
        long mixed = fnv1a32(sigBytes, 2166129450L);
        byte[] iv = new byte[16];
        int ivIdx = 0;
        long offset = 0;
        int loop = 0;
        while (loop != 48) {
            int idx = loop % sigLen;
            long charVal = s32(str.charAt(idx));
            long product = s32(mixed) * 29;
            long h = charVal + offset;
            mixed = u32(s32(h) ^ s32(product));
            long product2 = loraLen;
            iv[ivIdx] = (byte) lora.charAt((int) (mixed % product2));
            loop += 3;
            offset = u32(((long) 7) + offset);
            str = sig;
            ivIdx++;
            sigBytes = sigBytes;
        }
        return iv;
    }

    private final byte[] decodeBase64(String encoded) {
        String s = StringsKt.trim(encoded).toString();
        int mod = s.length() % 4;
        if (mod != 0) {
            s = s + StringsKt.repeat("=", 4 - mod);
        }
        return Base64.decode(s, 0);
    }

    private final byte[] pkcs7Unpad(byte[] data) {
        byte it;
        boolean z = false;
        if (data.length == 0) {
            return data;
        }
        int pad = ArraysKt.last(data) & 255;
        if (1 <= pad && pad < 17) {
            Iterable $this$all$iv = ArraysKt.takeLast(data, pad);
            if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                Iterator it2 = $this$all$iv.iterator();
                do {
                    if (it2.hasNext()) {
                        Object element$iv = it2.next();
                        byte it3 = ((Number) element$iv).byteValue();
                        it = it3 == ((byte) pad) ? (byte) 1 : (byte) 0;
                    } else {
                        z = true;
                        break;
                    }
                } while (it != 0);
            } else {
                z = true;
            }
            if (z) {
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length - pad);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                return bArrCopyOf;
            }
        }
        return data;
    }

    private final byte[] aesCbcDecrypt(byte[] ct, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            return pkcs7Unpad(cipher.doFinal(ct));
        } catch (Exception e) {
            return null;
        }
    }

    private final boolean isValidUtf8(byte[] data) {
        try {
            new String(data, Charsets.UTF_8);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static /* synthetic */ String decryptPlayFy$default(PlayFyCryptoUtils playFyCryptoUtils, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = DEFAULT_LORA;
        }
        if ((i & 4) != 0) {
            str3 = DEFAULT_SIG;
        }
        return playFyCryptoUtils.decryptPlayFy(str, str2, str3);
    }

    @Nullable
    public final String decryptPlayFy(@NotNull String encoded, @NotNull String lora, @NotNull String sig) {
        try {
            byte[] ctBytes = decodeBase64(encoded);
            byte[] key1 = deriveKey(lora, sig);
            byte[] iv1 = deriveIv(lora, sig);
            byte[] pt1 = aesCbcDecrypt(ctBytes, key1, iv1);
            if (pt1 != null && isValidUtf8(pt1)) {
                return new String(pt1, Charsets.UTF_8);
            }
            byte[] pt2 = aesCbcDecrypt(ctBytes, FALLBACK_KEY, FALLBACK_IV);
            if (pt2 == null || !isValidUtf8(pt2)) {
                return null;
            }
            return new String(pt2, Charsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    @NotNull
    public final String extractDataField(@NotNull String responseText) {
        try {
            Object obj = parseJsonToMap(responseText).get("data");
            String str = obj instanceof String ? (String) obj : null;
            return str == null ? StringsKt.trim(responseText).toString() : str;
        } catch (Exception e) {
            return StringsKt.trim(responseText).toString();
        }
    }

    private final Map<String, Object> parseJsonToMap(String json) {
        Object obj;
        Object objDecodeFromString;
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(Object.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Object obj2 = null;
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                }
            }
            if (!Result.isFailure-impl(obj)) {
                obj2 = obj;
            }
            DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
            if (deserializationStrategy != null) {
                try {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.PlayFyCryptoUtils$parseJsonToMap$$inlined$parseJson$1
                    });
                } catch (Throwable th3) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.PlayFyCryptoUtils$parseJsonToMap$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cncverse.PlayFyCryptoUtils$parseJsonToMap$$inlined$parseJson$1
                });
            }
            return (Map) objDecodeFromString;
        } catch (Exception e2) {
            return MapsKt.emptyMap();
        }
    }
}
