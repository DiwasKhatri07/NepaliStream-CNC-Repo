package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SubDecryptor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/KisskhProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002\u001a\f\u0010\u000f\u001a\u00020\f*\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"KEY", "", "KEY2", "KEY3", "IV", "", "IV2", "IV3", "decrypt", "encryptedB64", "decryptWithKeyIv", "keyBytes", "", "ivBytes", "encryptedBytes", "toByteArray", "KisskhProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSubDecryptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubDecryptor.kt\ncom/phisher98/SubDecryptorKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,53:1\n15196#2,3:54\n*S KotlinDebug\n*F\n+ 1 SubDecryptor.kt\ncom/phisher98/SubDecryptorKt\n*L\n46#1:54,3\n*E\n"})
public final class SubDecryptorKt {

    /* JADX INFO: renamed from: IV */
    @NotNull
    private static final int[] f5IV = {1382367819, 1465333859, 1902406224, 1164854838};

    @NotNull
    private static final int[] IV2 = {909653298, 909193779, 925905208, 892483379};

    @NotNull
    private static final int[] IV3 = {946894696, 1634749029, 1127508082, 1396271183};

    @NotNull
    private static final String KEY = "AmSmZVcH93UQUezi";

    @NotNull
    private static final String KEY2 = "8056483646328763";

    @NotNull
    private static final String KEY3 = "sWODXX04QRTkHdlZ";

    @NotNull
    public static final String decrypt(@NotNull String encryptedB64) {
        byte[] bytes = KEY.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = KEY2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] bytes3 = KEY3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        List keyIvPairs = CollectionsKt.listOf(new Pair[]{new Pair(bytes, toByteArray(f5IV)), new Pair(bytes2, toByteArray(IV2)), new Pair(bytes3, toByteArray(IV3))});
        byte[] encryptedBytes = MainAPIKt.base64DecodeArray(encryptedB64);
        Iterator it = keyIvPairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            byte[] keyBytes = (byte[]) pair.component1();
            byte[] ivBytes = (byte[]) pair.component2();
            try {
                return decryptWithKeyIv(keyBytes, ivBytes, encryptedBytes);
            } catch (Exception ex) {
                System.out.println((Object) ("Decryption attempt failed with key/IV pair. Error: " + ex.getMessage()));
            }
        }
        return "Decryption failed: All keys/IVs failed";
    }

    private static final String decryptWithKeyIv(byte[] keyBytes, byte[] ivBytes, byte[] encryptedBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(keyBytes, "AES"), new IvParameterSpec(ivBytes));
        return new String(cipher.doFinal(encryptedBytes), Charsets.UTF_8);
    }

    private static final byte[] toByteArray(int[] $this$toByteArray) {
        byte[] bytes = new byte[$this$toByteArray.length * 4];
        int index$iv = 0;
        int length = $this$toByteArray.length;
        int i = 0;
        while (i < length) {
            int item$iv = $this$toByteArray[i];
            bytes[index$iv * 4] = (byte) (item$iv >> 24);
            bytes[(index$iv * 4) + 1] = (byte) (item$iv >> 16);
            bytes[(index$iv * 4) + 2] = (byte) (item$iv >> 8);
            bytes[(index$iv * 4) + 3] = (byte) item$iv;
            i++;
            index$iv++;
        }
        return bytes;
    }
}
