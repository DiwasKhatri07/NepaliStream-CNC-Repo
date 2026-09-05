package com.hdhub4u;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/HDhub4u/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\f\u0010\n\u001a\u00020\u000b*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/hdhub4u/AesHelper;", "", "<init>", "()V", "TRANSFORMATION", "", "decryptAES", "inputHex", "key", "iv", "hexToByteArray", "", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/hdhub4u/AesHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,502:1\n1#2:503\n1739#3:504\n1814#3,3:505\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/hdhub4u/AesHelper\n*L\n118#1:504\n118#1:505,3\n*E\n"})
public final class AesHelper {

    @NotNull
    public static final AesHelper INSTANCE = new AesHelper();

    @NotNull
    private static final String TRANSFORMATION = "AES/CBC/PKCS5PADDING";

    private AesHelper() {
    }

    @NotNull
    public final String decryptAES(@NotNull String inputHex, @NotNull String key, @NotNull String iv) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        byte[] bytes = key.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        SecretKeySpec secretKey = new SecretKeySpec(bytes, "AES");
        byte[] bytes2 = iv.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        IvParameterSpec ivSpec = new IvParameterSpec(bytes2);
        cipher.init(2, secretKey, ivSpec);
        byte[] decryptedBytes = cipher.doFinal(hexToByteArray(inputHex));
        return new String(decryptedBytes, Charsets.UTF_8);
    }

    private final byte[] hexToByteArray(String $this$hexToByteArray) {
        if (!($this$hexToByteArray.length() % 2 == 0)) {
            throw new IllegalStateException("Hex string must have an even length".toString());
        }
        Iterable $this$map$iv = StringsKt.chunked($this$hexToByteArray, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        return CollectionsKt.toByteArray((List) destination$iv$iv);
    }
}
