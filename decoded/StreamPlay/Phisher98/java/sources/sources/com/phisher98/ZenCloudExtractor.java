package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0005H\u0002J \u0010\"\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006("}, d2 = {"Lcom/phisher98/ZenCloudExtractor;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractJsonBlock", "html", "key", "extractArrayBlock", "wasmDeriveKey", "", "frag1", "frag2", "frag3", "seed", "aesCbcDecrypt", "iv", "ciphertext", "sha256", "input", "b64Decode", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/ZenCloudExtractor\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,4003:1\n1505#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/ZenCloudExtractor\n*L\n3065#1:4004,2\n*E\n"})
public final class ZenCloudExtractor extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "ZenCloud";

    @NotNull
    private final String mainUrl = "https://zencloudz.cc";

    /* JADX INFO: renamed from: com.phisher98.ZenCloudExtractor$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ZenCloudExtractor", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {2973, 3019, 3051, 3072}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "html", "seed", "dataBlock", "dataJson", "h1", "h2", "keyField", "ivField", "containerName", "arrayName", "objectName", "tokenField", "keyFrag2Field", "container", "arr", "arrObj", "obj", "frag1B64", "ivB64", "frag2B64", "token", "url", "referer", "subtitleCallback", "callback", "html", "seed", "dataBlock", "dataJson", "h1", "h2", "keyField", "ivField", "containerName", "arrayName", "objectName", "tokenField", "keyFrag2Field", "container", "arr", "arrObj", "obj", "frag1B64", "ivB64", "frag2B64", "token", "apiResponse", "apiJson", "videoB64", "frag3B64", "aesKey", "streamUrl", "url", "referer", "subtitleCallback", "callback", "html", "seed", "dataBlock", "dataJson", "h1", "h2", "keyField", "ivField", "containerName", "arrayName", "objectName", "tokenField", "keyFrag2Field", "container", "arr", "arrObj", "obj", "frag1B64", "ivB64", "frag2B64", "token", "apiResponse", "apiJson", "videoB64", "frag3B64", "aesKey", "streamUrl", "subtitlesBlock", "$this$forEach$iv", "element$iv", "entry", "entryStr", "lang", "subUrl"}, nl = {2974, 3020, 3050, 3074}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "L$36", "L$37", "L$38"}, v = 2)
    static final class C03151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$33;
        Object L$34;
        Object L$35;
        Object L$36;
        Object L$37;
        Object L$38;
        Object L$39;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C03151(Continuation<? super C03151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZenCloudExtractor.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x088c  */
    /* JADX WARN: Code duplicated, block: B:111:0x08ba  */
    /* JADX WARN: Code duplicated, block: B:114:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:117:0x08e5  */
    /* JADX WARN: Code duplicated, block: B:122:0x08f8  */
    /* JADX WARN: Code duplicated, block: B:126:0x0904  */
    /* JADX WARN: Code duplicated, block: B:130:0x090d  */
    /* JADX WARN: Code duplicated, block: B:132:0x0910  */
    /* JADX WARN: Code duplicated, block: B:134:0x0a07 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x0a08  */
    /* JADX WARN: Code duplicated, block: B:137:0x0a55  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x0a08 -> B:136:0x0a33). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x0a55 -> B:138:0x0a69). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r55, @org.jetbrains.annotations.Nullable java.lang.String r56, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r57, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r58, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r59) {
        /*
            Method dump skipped, instruction units count: 3080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.ZenCloudExtractor.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.ZenCloudExtractor$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ZenCloudExtractor$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03162 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03162(Continuation<? super C03162> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c03162 = ZenCloudExtractor.this.new C03162(continuation);
            c03162.L$0 = obj;
            return c03162;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer(ZenCloudExtractor.this.getMainUrl());
                    $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String extractJsonBlock(String html, String key) {
        MatchResult match = Regex.find$default(new Regex("\"?" + Regex.Companion.escape(key) + "\"?\\s*:\\s*(\\{)"), html, 0, 2, (Object) null);
        if (match == null) {
            return null;
        }
        MatchGroup matchGroup = match.getGroups().get(1);
        Intrinsics.checkNotNull(matchGroup);
        int startIdx = matchGroup.getRange().getFirst();
        int depth = 0;
        for (int i = startIdx; i < html.length(); i++) {
            switch (html.charAt(i)) {
                case '{':
                    depth++;
                    break;
                case '}':
                    depth--;
                    if (depth == 0) {
                        String strSubstring = html.substring(startIdx, i + 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        return strSubstring;
                    }
                    break;
                    break;
            }
        }
        return null;
    }

    private final String extractArrayBlock(String html, String key) {
        MatchResult match = Regex.find$default(new Regex("\"?" + Regex.Companion.escape(key) + "\"?\\s*:\\s*(\\[)"), html, 0, 2, (Object) null);
        if (match == null) {
            return null;
        }
        MatchGroup matchGroup = match.getGroups().get(1);
        Intrinsics.checkNotNull(matchGroup);
        int startIdx = matchGroup.getRange().getFirst();
        int depth = 0;
        for (int i = startIdx; i < html.length(); i++) {
            switch (html.charAt(i)) {
                case '[':
                    depth++;
                    break;
                case ']':
                    depth--;
                    if (depth == 0) {
                        String strSubstring = html.substring(startIdx, i + 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        return strSubstring;
                    }
                    break;
                    break;
            }
        }
        return null;
    }

    private final byte[] wasmDeriveKey(byte[] frag1, byte[] frag2, byte[] frag3, String seed) {
        int seedInt = (int) Long.parseLong(StringsKt.take(seed, 8), CharsKt.checkRadix(16));
        byte[] lookup = new byte[512];
        for (int i = 0; i < 512; i++) {
            lookup[i] = (byte) (((i * 37) + seedInt) & 255);
        }
        int length = frag1.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int a = frag1[i2] & 255;
            int b = frag2[i2] & 255;
            int c = frag3[i2] & 255;
            int lut = lookup[i2 & 255] & 255;
            bArr[i2] = (byte) (((a ^ b) ^ c) ^ lut);
        }
        return bArr;
    }

    private final String aesCbcDecrypt(byte[] key, byte[] iv, byte[] ciphertext) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        return new String(cipher.doFinal(ciphertext), Charsets.UTF_8);
    }

    private final String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return ArraysKt.joinToString$default(messageDigest.digest(bytes), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.ZenCloudExtractor$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ZenCloudExtractor.sha256$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence sha256$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final byte[] b64Decode(String input) {
        return MainAPIKt.base64DecodeArray(input);
    }
}
