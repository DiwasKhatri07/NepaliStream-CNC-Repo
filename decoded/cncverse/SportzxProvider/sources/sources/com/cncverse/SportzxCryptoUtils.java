package com.cncverse;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxCryptoUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005J\u0012\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J0\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001aH\u0002J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u001aH\u0002J \u0010/\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0002J\u0018\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u001aH\u0002J$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070 2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0002J(\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0007H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0012\u0010A\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/cncverse/SportzxCryptoUtils;", "", "<init>", "()V", "APP_PASSWORD", "", "CHARSET", "", "AES_KEY", "AES_IV", "MAGIC", "PRK", "CTX_HASH", "V3_VERSION_BYTE", "", "V3_SXR_LABEL", "V3_PEPPER", "SXR_CONSTS", "", "V2_PRK_LABEL", "V2_MAC_LABEL", "V2_ENC_LABEL", "V2_VERSION_BYTE", "decodeHex", "hex", "rotr3", "", "b", "u32", "", "x", "generateAesKeyIv", "Lkotlin/Pair;", "s", "decrypt", "b64Data", "decryptV3", "sxrQr", "", "a", "c", "d", "sxrPermute", "state", "ld32le", "buf", "off", "st32le", "value", "sxrPrf", "data", "length", "sxrDerive", "certHash", "iv", "sxrBlock", "streamState", "blockCounter", "counterWords", "out", "decryptV2", "hmacSha256", "key", "urlSafeB64Decode", "decryptPrimary", "decryptFallback", "decryptFallback2", "SxrSponge", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSportzxCryptoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportzxCryptoUtils.kt\ncom/cncverse/SportzxCryptoUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,506:1\n1#2:507\n*E\n"})
public final class SportzxCryptoUtils {

    @NotNull
    private static final byte[] AES_IV;

    @NotNull
    private static final byte[] AES_KEY;

    @NotNull
    private static final String APP_PASSWORD = "oAR80SGuX3EEjUGFRwLFKBTiris=";

    @NotNull
    private static final byte[] CHARSET;

    @NotNull
    private static final byte[] CTX_HASH;

    @NotNull
    public static final SportzxCryptoUtils INSTANCE = new SportzxCryptoUtils();

    @NotNull
    private static final byte[] MAGIC;

    @NotNull
    private static final byte[] PRK;

    @NotNull
    private static final int[] SXR_CONSTS;

    @NotNull
    private static final byte[] V2_ENC_LABEL;

    @NotNull
    private static final byte[] V2_MAC_LABEL;

    @NotNull
    private static final byte[] V2_PRK_LABEL;
    private static final byte V2_VERSION_BYTE = 2;

    @NotNull
    private static final byte[] V3_PEPPER;

    @NotNull
    private static final byte[] V3_SXR_LABEL;
    private static final byte V3_VERSION_BYTE = 3;

    private SportzxCryptoUtils() {
    }

    static {
        byte[] bytes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+!@#$%&=".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        CHARSET = bytes;
        Pair<byte[], byte[]> pairGenerateAesKeyIv = INSTANCE.generateAesKeyIv(APP_PASSWORD);
        byte[] k = (byte[]) pairGenerateAesKeyIv.component1();
        byte[] iv = (byte[]) pairGenerateAesKeyIv.component2();
        AES_KEY = k;
        AES_IV = iv;
        MAGIC = new byte[]{-34, -83, -66, -17};
        PRK = INSTANCE.decodeHex("d1a7ebbaed93b2f68ac092ade2b0075d917634447a3519b41e817ad631020053");
        CTX_HASH = INSTANCE.decodeHex("1676ec7db4771b0d826d70369b579684b182d2c0133be041bdd55f5d6d79a98b");
        byte[] bytes2 = "SXR3/kdf".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        V3_SXR_LABEL = bytes2;
        V3_PEPPER = new byte[]{-79, 101, 125, -29, 9, -42, -25, -112, 96, 122, 92, 78, -25, -47, -81, 72, 83, -11, 113, -123, 125, -55, 101, -26, 92, -75, 103, 67, -110, 58, 69, 121};
        SXR_CONSTS = new int[]{1398297139, -1640531527, 2101127200, -1028477379};
        byte[] bytes3 = "sportzx/v2/prk".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        V2_PRK_LABEL = bytes3;
        byte[] bytes4 = "mac".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
        V2_MAC_LABEL = bytes4;
        byte[] bytes5 = "enc".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes5, "getBytes(...)");
        V2_ENC_LABEL = bytes5;
    }

    private final byte[] decodeHex(String hex) {
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

    private final int rotr3(int b) {
        return ((b >>> 3) | (b << 5)) & 255;
    }

    private final long u32(long x) {
        return 4294967295L & x;
    }

    private final Pair<byte[], byte[]> generateAesKeyIv(String s) {
        long j;
        long j2;
        byte[] data = s.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(data, "getBytes(...)");
        int n = data.length;
        long u = u32(2166136261L);
        int length = data.length;
        int i = 0;
        while (true) {
            j = 16777619;
            j2 = 255;
            if (i >= length) {
                break;
            }
            byte b = data[i];
            u = u32(((255 & ((long) b)) ^ u) * 16777619);
            i++;
        }
        byte[] key = new byte[16];
        int i2 = 0;
        while (i2 < 16) {
            long b2 = ((long) data[i2 % n]) & j2;
            u = u32((((long) 31) * u) + (((long) i2) ^ b2));
            key[i2] = CHARSET[(int) (u % ((long) CHARSET.length))];
            i2++;
            j = j;
            j2 = j2;
        }
        long j3 = j;
        long j4 = j2;
        long u2 = u32(2166129450L);
        for (byte b3 : data) {
            u2 = u32(((((long) b3) & j4) ^ u2) * j3);
        }
        byte[] iv = new byte[16];
        int idx = 0;
        long acc = 0;
        while (idx != 48) {
            long b4 = ((long) data[idx % n]) & j4;
            u2 = u32((((long) 29) * u2) + (acc ^ b4));
            iv[idx / 3] = CHARSET[(int) (u2 % ((long) CHARSET.length))];
            idx += 3;
            acc = u32(((long) 7) + acc);
            data = data;
        }
        return new Pair<>(key, iv);
    }

    @Nullable
    public final String decrypt(@NotNull String b64Data) {
        String trimmed = StringsKt.trim(b64Data).toString();
        if (trimmed.length() == 0) {
            return null;
        }
        String it = decryptV3(trimmed);
        if (it != null) {
            return it;
        }
        String it2 = decryptV2(trimmed);
        if (it2 != null) {
            return it2;
        }
        String it3 = decryptPrimary(trimmed);
        if (it3 != null) {
            return it3;
        }
        String it4 = decryptFallback(trimmed);
        if (it4 != null) {
            return it4;
        }
        String it5 = decryptFallback2(trimmed);
        if (it5 != null) {
            return it5;
        }
        return null;
    }

    private final String decryptV3(String b64Data) {
        SportzxCryptoUtils sportzxCryptoUtils = this;
        try {
            byte[] raw = urlSafeB64Decode(b64Data);
            if (raw.length < 45) {
                throw new IllegalArgumentException("v3 blob too short (" + raw.length + ')');
            }
            if (raw[0] != 3) {
                StringBuilder sbAppend = new StringBuilder().append("not a v3 blob (version=0x");
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(raw[0])}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                throw new IllegalArgumentException(sbAppend.append(str).append(')').toString());
            }
            byte[] iv = ArraysKt.copyOfRange(raw, 1, 17);
            int[] counterWords = new int[3];
            for (int i = 0; i < 3; i++) {
                counterWords[i] = INSTANCE.ld32le(raw, (i * 4) + 17);
            }
            byte[] ct = ArraysKt.copyOfRange(raw, 29, raw.length - 16);
            byte[] tag = ArraysKt.copyOfRange(raw, raw.length - 16, raw.length);
            Pair<int[], byte[]> pairSxrDerive = sportzxCryptoUtils.sxrDerive(CTX_HASH, iv);
            int[] streamState = (int[]) pairSxrDerive.component1();
            byte[] macKey = (byte[]) pairSxrDerive.component2();
            SxrSponge sponge = new SxrSponge();
            SxrSponge.absorb$default(sponge, macKey, 32, 0, 4, null);
            sponge.absorb(raw, 29, 0);
            sponge.absorb(ct, ct.length, 0);
            SxrSponge.absorb$default(sponge, macKey, 32, 0, 4, null);
            byte[] computedTag = new byte[32];
            SxrSponge.final$default(sponge, computedTag, 0, 2, null);
            int diff = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                diff |= computedTag[i2] ^ tag[i2];
            }
            if (diff != 0) {
                throw new IllegalArgumentException("HMAC tag mismatch — wrong cert_hash or tampered payload");
            }
            byte[] pt = new byte[ct.length];
            byte[] block = new byte[64];
            int offset = 0;
            int blockCounter = 0;
            while (offset < ct.length) {
                sportzxCryptoUtils.sxrBlock(streamState, blockCounter, counterWords, block);
                int chunk = Math.min(64, ct.length - offset);
                for (int i3 = 0; i3 < chunk; i3++) {
                    pt[offset + i3] = (byte) (ct[offset + i3] ^ block[i3]);
                }
                offset += chunk;
                blockCounter++;
                sportzxCryptoUtils = this;
            }
            return new String(pt, Charsets.UTF_8);
        } catch (Exception e) {
            System.out.println((Object) ("SportzxCrypto: v3 decryption failed — " + e.getMessage()));
            return null;
        }
    }

    private final void sxrQr(int[] s, int a, int b, int c, int d) {
        s[a] = s[a] + s[b];
        s[d] = Integer.rotateLeft(s[d] ^ s[a], 13);
        s[c] = s[c] + s[d];
        s[b] = Integer.rotateLeft(s[b] ^ s[c], 17);
        s[a] = s[a] + s[b];
        s[d] = Integer.rotateLeft(s[d] ^ s[a], 9);
        s[c] = s[c] + s[d];
        s[b] = Integer.rotateLeft(s[b] ^ s[c], 25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sxrPermute(int[] state) {
        int round = 0;
        while (round < 10) {
            int[] state2 = state;
            sxrQr(state2, 0, 4, 8, 12);
            sxrQr(state2, 1, 5, 9, 13);
            sxrQr(state2, 2, 6, 10, 14);
            sxrQr(state2, 3, 7, 11, 15);
            sxrQr(state2, 0, 5, 10, 15);
            sxrQr(state2, 1, 6, 11, 12);
            sxrQr(state2, 2, 7, 8, 13);
            sxrQr(state2, 3, 4, 9, 14);
            round++;
            state = state2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int ld32le(byte[] buf, int off) {
        return (buf[off] & 255) | ((buf[off + 1] & 255) << 8) | ((buf[off + 2] & 255) << 16) | ((buf[off + 3] & 255) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void st32le(byte[] buf, int off, int value) {
        buf[off] = (byte) (value & 255);
        buf[off + 1] = (byte) ((value >>> 8) & 255);
        buf[off + 2] = (byte) ((value >>> 16) & 255);
        buf[off + 3] = (byte) ((value >>> 24) & 255);
    }

    /* JADX INFO: compiled from: SportzxCryptoUtils.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\rJ\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/cncverse/SportzxCryptoUtils$SxrSponge;", "", "<init>", "()V", "state", "", "getState", "()[I", "buf", "", "getBuf", "()[B", "pos", "", "getPos", "()I", "setPos", "(I)V", "absorb", "", "data", "length", "offset", "final", "out", "outOffset", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class SxrSponge {

        @NotNull
        private final byte[] buf;
        private int pos;

        @NotNull
        private final int[] state;

        public SxrSponge() {
            int[] iArr = new int[16];
            int i = 0;
            while (i < 16) {
                int i2 = i + 1;
                iArr[i] = (-1640531527) * i2;
                i = i2;
            }
            this.state = iArr;
            this.buf = new byte[32];
        }

        @NotNull
        public final int[] getState() {
            return this.state;
        }

        @NotNull
        public final byte[] getBuf() {
            return this.buf;
        }

        public final int getPos() {
            return this.pos;
        }

        public final void setPos(int i) {
            this.pos = i;
        }

        public static /* synthetic */ void absorb$default(SxrSponge sxrSponge, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = bArr.length;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            sxrSponge.absorb(bArr, i, i2);
        }

        public final void absorb(@NotNull byte[] data, int length, int offset) {
            for (int i = 0; i < length; i++) {
                byte[] bArr = this.buf;
                int i2 = this.pos;
                this.pos = i2 + 1;
                bArr[i2] = data[offset + i];
                if (this.pos == 32) {
                    for (int j = 0; j < 8; j++) {
                        this.state[j] = this.state[j] ^ SportzxCryptoUtils.INSTANCE.ld32le(this.buf, j * 4);
                    }
                    SportzxCryptoUtils.INSTANCE.sxrPermute(this.state);
                    this.pos = 0;
                }
            }
        }

        public static /* synthetic */ void final$default(SxrSponge sxrSponge, byte[] bArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            sxrSponge.m1final(bArr, i);
        }

        /* JADX INFO: renamed from: final, reason: not valid java name */
        public final void m1final(@NotNull byte[] out, int outOffset) {
            byte[] bArr = this.buf;
            int i = this.pos;
            this.pos = i + 1;
            bArr[i] = -128;
            while (this.pos < 32) {
                byte[] bArr2 = this.buf;
                int i2 = this.pos;
                this.pos = i2 + 1;
                bArr2[i2] = 0;
            }
            for (int j = 0; j < 8; j++) {
                this.state[j] = this.state[j] ^ SportzxCryptoUtils.INSTANCE.ld32le(this.buf, j * 4);
            }
            SportzxCryptoUtils.INSTANCE.sxrPermute(this.state);
            for (int j2 = 0; j2 < 8; j2++) {
                SportzxCryptoUtils.INSTANCE.st32le(out, (j2 * 4) + outOffset, this.state[j2]);
            }
        }
    }

    private final byte[] sxrPrf(byte[] data, int length) {
        SxrSponge sponge = new SxrSponge();
        SxrSponge.absorb$default(sponge, data, length, 0, 4, null);
        byte[] out = new byte[32];
        SxrSponge.final$default(sponge, out, 0, 2, null);
        return out;
    }

    private final Pair<int[], byte[]> sxrDerive(byte[] certHash, byte[] iv) {
        byte[] buf = new byte[88];
        System.arraycopy(V3_SXR_LABEL, 0, buf, 0, 8);
        System.arraycopy(certHash, 0, buf, 8, 32);
        System.arraycopy(V3_PEPPER, 0, buf, 40, 32);
        System.arraycopy(iv, 0, buf, 72, 16);
        byte[] seed = sxrPrf(buf, 88);
        byte[] encKeyInput = new byte[33];
        System.arraycopy(seed, 0, encKeyInput, 0, 32);
        encKeyInput[32] = 1;
        byte[] encKey = sxrPrf(encKeyInput, 33);
        byte[] macKeyInput = new byte[33];
        System.arraycopy(seed, 0, macKeyInput, 0, 32);
        macKeyInput[32] = V2_VERSION_BYTE;
        byte[] macKey = sxrPrf(macKeyInput, 33);
        int[] streamState = new int[8];
        for (int i = 0; i < 8; i++) {
            streamState[i] = INSTANCE.ld32le(encKey, i * 4);
        }
        return new Pair<>(streamState, macKey);
    }

    private final void sxrBlock(int[] streamState, int blockCounter, int[] counterWords, byte[] out) {
        int[] state = new int[16];
        System.arraycopy(SXR_CONSTS, 0, state, 0, 4);
        System.arraycopy(streamState, 0, state, 4, 8);
        state[12] = blockCounter;
        System.arraycopy(counterWords, 0, state, 13, 3);
        int[] working = (int[]) state.clone();
        sxrPermute(working);
        for (int i = 0; i < 16; i++) {
            working[i] = working[i] + state[i];
        }
        for (int i2 = 0; i2 < 16; i2++) {
            st32le(out, i2 * 4, working[i2]);
        }
    }

    private final String decryptV2(String b64Data) {
        SportzxCryptoUtils sportzxCryptoUtils = this;
        try {
            byte[] raw = urlSafeB64Decode(b64Data);
            if (raw.length < 49) {
                throw new IllegalArgumentException("v2 blob too short (" + raw.length + ')');
            }
            if (raw[0] != 2) {
                StringBuilder sbAppend = new StringBuilder().append("not a v2 blob (version=0x");
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(raw[0])}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                throw new IllegalArgumentException(sbAppend.append(str).append(')').toString());
            }
            byte[] iv = ArraysKt.copyOfRange(raw, 1, 17);
            byte[] tag = ArraysKt.copyOfRange(raw, raw.length - 32, raw.length);
            byte[] ct = ArraysKt.copyOfRange(raw, 17, raw.length - 32);
            if (ct.length % 16 != 0) {
                throw new IllegalArgumentException("ct length " + ct.length + " not 16-aligned");
            }
            byte[] prk = sportzxCryptoUtils.hmacSha256(V2_PRK_LABEL, CTX_HASH);
            byte[] macKey = sportzxCryptoUtils.hmacSha256(prk, V2_MAC_LABEL);
            byte[] encKey = sportzxCryptoUtils.hmacSha256(prk, V2_ENC_LABEL);
            byte[] dataToMac = new byte[raw.length - 32];
            System.arraycopy(raw, 0, dataToMac, 0, raw.length - 32);
            byte[] expectedTag = sportzxCryptoUtils.hmacSha256(macKey, dataToMac);
            if (!Arrays.equals(expectedTag, tag)) {
                throw new IllegalArgumentException("HMAC tag mismatch — wrong cert_hash or tampered payload");
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(encKey, "AES"), new IvParameterSpec(iv));
            byte[] aesOut = cipher.doFinal(ct);
            byte[] plain = new byte[aesOut.length];
            int i = 0;
            int length = aesOut.length;
            while (i < length) {
                int b = aesOut[i] & 255;
                plain[i] = (byte) (sportzxCryptoUtils.rotr3(b) ^ (CTX_HASH[i % CTX_HASH.length] & 255));
                i++;
                sportzxCryptoUtils = this;
            }
            return new String(plain, Charsets.UTF_8);
        } catch (Exception e) {
            System.out.println((Object) ("SportzxCrypto: v2 decryption failed — " + e.getMessage()));
            return null;
        }
    }

    private final byte[] hmacSha256(byte[] key, byte[] data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key, "HmacSHA256"));
        return mac.doFinal(data);
    }

    private final byte[] urlSafeB64Decode(String s) {
        String std = StringsKt.replace$default(StringsKt.replace$default(s, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
        while (std.length() % 4 != 0) {
            std = std + '=';
        }
        return Base64.decode(std, 0);
    }

    private final String decryptPrimary(String b64Data) {
        try {
            byte[] blob = urlSafeB64Decode(b64Data);
            try {
                if (blob.length >= 5 && blob[0] == MAGIC[0]) {
                    int i = 1;
                    if (blob[1] == MAGIC[1] && blob[2] == MAGIC[2] && blob[3] == MAGIC[3]) {
                        int n = blob[4] & 255;
                        int total = blob.length;
                        if (total < n + 5) {
                            throw new Exception("Blob too short");
                        }
                        byte[] payload = n > 0 ? ArraysKt.copyOfRange(blob, 5, total - n) : ArraysKt.copyOfRange(blob, 5, total);
                        byte[] tail = n > 0 ? ArraysKt.copyOfRange(blob, total - n, total) : new byte[0];
                        if (payload.length == 0) {
                            return "";
                        }
                        if (payload.length % 16 != 0) {
                            throw new Exception("Payload length not AES-block-aligned");
                        }
                        byte[] hmacKey = new byte[tail.length + CTX_HASH.length];
                        System.arraycopy(tail, 0, hmacKey, 0, tail.length);
                        System.arraycopy(CTX_HASH, 0, hmacKey, tail.length, CTX_HASH.length);
                        Mac mac = Mac.getInstance("HmacSHA256");
                        mac.init(new SecretKeySpec(hmacKey, "HmacSHA256"));
                        ByteArrayOutputStream output = new ByteArrayOutputStream();
                        byte[] prev = new byte[0];
                        int counter = 1;
                        while (output.size() < 48) {
                            byte[] input = new byte[prev.length + hmacKey.length + i];
                            System.arraycopy(prev, 0, input, 0, prev.length);
                            System.arraycopy(hmacKey, 0, input, prev.length, hmacKey.length);
                            input[input.length - 1] = (byte) counter;
                            byte[] h = mac.doFinal(input);
                            output.write(h);
                            prev = h;
                            counter++;
                            i = 1;
                        }
                        byte[] kmat = output.toByteArray();
                        byte[] aesKey = ArraysKt.copyOfRange(kmat, 0, 32);
                        byte[] aesIv = ArraysKt.copyOfRange(kmat, 32, 48);
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(2, new SecretKeySpec(aesKey, "AES"), new IvParameterSpec(aesIv));
                        byte[] raw = cipher.doFinal(payload);
                        byte[] result = new byte[raw.length];
                        int i2 = 0;
                        int length = raw.length;
                        while (i2 < length) {
                            byte[] raw2 = raw;
                            int b = raw2[i2] & 255;
                            int i3 = length;
                            int r3 = rotr3(b);
                            result[i2] = (byte) (r3 ^ (CTX_HASH[i2 % CTX_HASH.length] & 255));
                            i2++;
                            raw = raw2;
                            length = i3;
                        }
                        return new String(result, Charsets.UTF_8);
                        System.out.println((Object) ("SportzxCrypto: Primary decryption failed — " + e.getMessage()));
                        return null;
                    }
                }
                throw new Exception("Bad magic");
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private final String decryptFallback(String b64Data) {
        try {
            byte[] data = urlSafeB64Decode(b64Data);
            int saltLen = data[4] & 255;
            byte[] salt = ArraysKt.copyOfRange(data, data.length - saltLen, data.length);
            byte[] ciphertext = ArraysKt.copyOfRange(data, 5, data.length - saltLen);
            byte[] info = new byte[salt.length + CTX_HASH.length];
            System.arraycopy(salt, 0, info, 0, salt.length);
            System.arraycopy(CTX_HASH, 0, info, salt.length, CTX_HASH.length);
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(PRK, "HmacSHA256"));
            byte[] info1 = new byte[info.length + 1];
            System.arraycopy(info, 0, info1, 0, info.length);
            info1[info.length] = 1;
            byte[] t1 = mac.doFinal(info1);
            byte[] info2 = new byte[t1.length + info.length + 1];
            System.arraycopy(t1, 0, info2, 0, t1.length);
            System.arraycopy(info, 0, info2, t1.length, info.length);
            info2[info2.length - 1] = V2_VERSION_BYTE;
            byte[] t2 = mac.doFinal(info2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] iv = ArraysKt.copyOfRange(t2, 0, 16);
            cipher.init(2, new SecretKeySpec(t1, "AES"), new IvParameterSpec(iv));
            byte[] aesOut = cipher.doFinal(ciphertext);
            byte[] plaintext = new byte[aesOut.length];
            int i = 0;
            int length = aesOut.length;
            while (i < length) {
                byte[] info3 = info1;
                int b = aesOut[i] & 255;
                int rol5 = ((b << 5) & 255) | (b >>> 3);
                int rol6 = CTX_HASH[i % 32];
                plaintext[i] = (byte) (rol5 ^ (rol6 & 255));
                i++;
                info1 = info3;
            }
            return new String(plaintext, Charsets.UTF_8);
        } catch (Exception e) {
            System.out.println((Object) ("SportzxCrypto: Fallback decryption failed — " + e.getMessage()));
            return null;
        }
    }

    private final String decryptFallback2(String b64Data) {
        try {
            byte[] ct = Base64.decode(b64Data, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(AES_KEY, "AES"), new IvParameterSpec(AES_IV));
            byte[] pt = cipher.doFinal(ct);
            return new String(pt, Charsets.UTF_8);
        } catch (Exception e) {
            System.out.println((Object) ("SportzxCrypto: Fallback2 decryption failed — " + e.getMessage()));
            return null;
        }
    }
}
