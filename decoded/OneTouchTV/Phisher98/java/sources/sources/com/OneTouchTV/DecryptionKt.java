package com.OneTouchTV;

import com.lagradost.cloudstream3.MainAPIKt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: Decryption.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OneTouchTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001\u001a\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"keyHex", "", "ivHex", "key", "", "iv", "normalizeCustomAlphabet", "s", "base64ToBytes", "b64", "decryptAes256Cbc", "cipherBytes", "decryptString", "input", "OneTouchTV"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDecryption.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Decryption.kt\ncom/OneTouchTV/DecryptionKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n1739#2:77\n1814#2,3:78\n1739#2:81\n1814#2,3:82\n*S KotlinDebug\n*F\n+ 1 Decryption.kt\ncom/OneTouchTV/DecryptionKt\n*L\n12#1:77\n12#1:78,3\n13#1:81\n13#1:82,3\n*E\n"})
public final class DecryptionKt {

    /* JADX INFO: renamed from: iv */
    @NotNull
    private static final byte[] f2iv;

    @NotNull
    private static final byte[] key;

    @NotNull
    private static final String keyHex = MainAPIKt.base64Decode("Njk2ZDM3MzI2MzY4NjE3MjUwNjE3MzczNzc2ZjcyNjQ2ZjY2NjQ0OTZlNjk3NDU2NjU2Mzc0NmY3MjUzNzQ2ZA==");

    @NotNull
    private static final String ivHex = MainAPIKt.base64Decode("Njk2ZDM3MzI2MzY4NjE3MjUwNjE3MzczNzc2ZjcyNjQ=");

    static {
        Iterable $this$map$iv = StringsKt.chunked(keyHex, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        key = CollectionsKt.toByteArray((List) destination$iv$iv);
        Iterable $this$map$iv2 = StringsKt.chunked(ivHex, 2);
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            String it2 = (String) item$iv$iv2;
            destination$iv$iv2.add(Byte.valueOf((byte) Integer.parseInt(it2, CharsKt.checkRadix(16))));
        }
        f2iv = CollectionsKt.toByteArray((List) destination$iv$iv2);
    }

    @NotNull
    public static final String normalizeCustomAlphabet(@NotNull String s) {
        return new Regex("\\s+").replace(StringsKt.replace$default(StringsKt.replace$default(s, "-_.", "/", false, 4, (Object) null), "@", "+", false, 4, (Object) null), "");
    }

    @NotNull
    public static final byte[] base64ToBytes(@NotNull String b64) {
        String base64Str = b64;
        int pad = base64Str.length() % 4;
        if (pad != 0) {
            base64Str = base64Str + StringsKt.repeat("=", 4 - pad);
        }
        return MainAPIKt.base64DecodeArray(base64Str);
    }

    @NotNull
    public static final byte[] decryptAes256Cbc(@NotNull byte[] cipherBytes, @NotNull byte[] key2, @NotNull byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (cipherBytes.length % 16 != 0) {
            throw new IllegalArgumentException("Ciphertext length (" + cipherBytes.length + ") not multiple of 16.");
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key2, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(2, secretKey, ivSpec);
        return cipher.doFinal(cipherBytes);
    }

    @NotNull
    public static final String decryptString(@NotNull String input) throws Exception {
        JSONObject json;
        String trimmed = StringsKt.trim(input).toString();
        JSONObject json2 = null;
        if (StringsKt.startsWith$default(trimmed, "{", false, 2, (Object) null) || StringsKt.startsWith$default(trimmed, "[", false, 2, (Object) null)) {
            try {
                json = new JSONObject(trimmed);
            } catch (Exception e) {
                json = null;
            }
            if (json != null) {
                if (json.has("result")) {
                    return json.get("result").toString();
                }
                return trimmed;
            }
            if (StringsKt.startsWith$default(trimmed, "[", false, 2, (Object) null)) {
                return trimmed;
            }
        }
        if (StringsKt.startsWith$default(trimmed, "<", false, 2, (Object) null)) {
            throw new Exception("Server returned HTML page (possibly Cloudflare or 404)");
        }
        try {
            String normalized = normalizeCustomAlphabet(input);
            byte[] cipherBytes = base64ToBytes(normalized);
            byte[] plaintextBytes = decryptAes256Cbc(cipherBytes, key, f2iv);
            String decryptedText = new String(plaintextBytes, Charsets.UTF_8);
            try {
                json2 = new JSONObject(decryptedText);
            } catch (Exception e2) {
            }
            if (json2 == null || !json2.has("result")) {
                return decryptedText;
            }
            return json2.get("result").toString();
        } catch (Exception e3) {
            throw new Exception("Invalid API payload format: " + e3.getMessage());
        }
    }
}
