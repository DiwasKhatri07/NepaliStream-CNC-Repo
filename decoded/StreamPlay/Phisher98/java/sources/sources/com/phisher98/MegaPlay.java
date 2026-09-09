package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0006\u001b\u001c\u001d\u001e\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/phisher98/MegaPlay;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signMegaPlayUrl", "decryptMegaPlaySources", "enc", "Companion", "MegaPlayResponse", "Source", "Track", "Intro", "Outro", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/MegaPlay\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4076:1\n73#2,5:4077\n1#3:4082\n2068#4,2:4083\n2068#4,2:4085\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/MegaPlay\n*L\n3212#1:4077,5\n3223#1:4083,2\n3231#1:4085,2\n*E\n"})
public class MegaPlay extends ExtractorApi {

    @NotNull
    private static final String ENC_IV = "W0;27ToaUpl_P%'c";

    @NotNull
    private static final String ENC_KEY = "i?LMTAx0Q6,:}50U";

    @NotNull
    private static final String TOKEN_SECRET = "MpCdnT0k3n!9f2K#xQ7vL5mR8wN1pY4s";
    private final boolean requiresReferer;

    @NotNull
    private final String name = "MegaPlay";

    @NotNull
    private final String mainUrl = "https://megaplay.buzz";

    /* JADX INFO: renamed from: com.phisher98.MegaPlay$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MegaPlay", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {3191, 3211, 3221, 3225, 3238}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "origin", "mainHeaders", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "origin", "mainHeaders", "headers", "page", "id", "type", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "origin", "mainHeaders", "headers", "page", "id", "type", "apiUrl", "response", "m3u8", "streamType", "streamLabel", "$this", "url", "referer", "subtitleCallback", "callback", "origin", "mainHeaders", "headers", "page", "id", "type", "apiUrl", "response", "m3u8", "streamType", "streamLabel", "generated", "$this", "url", "referer", "subtitleCallback", "callback", "origin", "mainHeaders", "headers", "page", "id", "type", "apiUrl", "response", "m3u8", "streamType", "streamLabel", "generated", "$this$forEach$iv", "element$iv", "track", "trackUrl", "file", "label"}, nl = {3193, 3212, 3222, 3231, 3237}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "L$20", "L$21", "L$22", "L$23"}, v = 2)
    static final class C00451 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00451(Continuation<? super C00451> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MegaPlay.getUrl$suspendImpl(MegaPlay.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
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

    /* JADX WARN: Code duplicated, block: B:137:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:178:0x074a A[Catch: Exception -> 0x08cc, TRY_LEAVE, TryCatch #3 {Exception -> 0x08cc, blocks: (B:176:0x0744, B:178:0x074a), top: B:242:0x0744 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0764 A[Catch: Exception -> 0x08c0, TryCatch #8 {Exception -> 0x08c0, blocks: (B:180:0x075c, B:182:0x0764, B:186:0x077b, B:189:0x078b, B:193:0x07c5, B:196:0x07cd, B:192:0x07a0, B:207:0x08b4), top: B:252:0x075c }] */
    /* JADX WARN: Code duplicated, block: B:186:0x077b A[Catch: Exception -> 0x08c0, TryCatch #8 {Exception -> 0x08c0, blocks: (B:180:0x075c, B:182:0x0764, B:186:0x077b, B:189:0x078b, B:193:0x07c5, B:196:0x07cd, B:192:0x07a0, B:207:0x08b4), top: B:252:0x075c }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0781  */
    /* JADX WARN: Code duplicated, block: B:189:0x078b A[Catch: Exception -> 0x08c0, TryCatch #8 {Exception -> 0x08c0, blocks: (B:180:0x075c, B:182:0x0764, B:186:0x077b, B:189:0x078b, B:193:0x07c5, B:196:0x07cd, B:192:0x07a0, B:207:0x08b4), top: B:252:0x075c }] */
    /* JADX WARN: Code duplicated, block: B:191:0x079c  */
    /* JADX WARN: Code duplicated, block: B:192:0x07a0 A[Catch: Exception -> 0x08c0, TryCatch #8 {Exception -> 0x08c0, blocks: (B:180:0x075c, B:182:0x0764, B:186:0x077b, B:189:0x078b, B:193:0x07c5, B:196:0x07cd, B:192:0x07a0, B:207:0x08b4), top: B:252:0x075c }] */
    /* JADX WARN: Code duplicated, block: B:195:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:198:0x0861 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:199:0x0862  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:185:0x0771 -> B:203:0x089c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:188:0x0781 -> B:203:0x089c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:199:0x0862 -> B:277:0x0884). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.MegaPlay r39, java.lang.String r40, java.lang.String r41, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r42, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r43, kotlin.coroutines.Continuation<? super kotlin.Unit> r44) {
        /*
            Method dump skipped, instruction units count: 2472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.MegaPlay.getUrl$suspendImpl(com.phisher98.MegaPlay, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.MegaPlay$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.MegaPlay$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00462 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $mainHeaders;
        final /* synthetic */ String $origin;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00462(String str, Map<String, String> map, Continuation<? super C00462> continuation) {
            super(2, continuation);
            this.$origin = str;
            this.$mainHeaders = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00462 = new C00462(this.$origin, this.$mainHeaders, continuation);
            c00462.L$0 = obj;
            return c00462;
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
                    $this$newExtractorLink.setReferer(this.$origin + '/');
                    $this$newExtractorLink.setHeaders(this.$mainHeaders);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String signMegaPlayUrl(String url) {
        Object obj;
        MatchResult m;
        try {
            Result.Companion companion = Result.Companion;
            MegaPlay megaPlay = this;
            if (StringsKt.contains$default(url, "token=", false, 2, (Object) null) || (m = Regex.find$default(new Regex("/([a-f0-9]{32})/([a-f0-9]{32})/", RegexOption.IGNORE_CASE), url, 0, 2, (Object) null)) == null) {
                return url;
            }
            String payload = ((System.currentTimeMillis() / 1000) + 90) + '|' + ((String) m.getGroupValues().get(1)) + '/' + ((String) m.getGroupValues().get(2));
            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] bytes = TOKEN_SECRET.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
            byte[] bytes2 = payload.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] sig = mac.doFinal(bytes2);
            StringBuilder sb = new StringBuilder();
            byte[] bytes3 = payload.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            String token = sb.append(signMegaPlayUrl$lambda$0$b64(bytes3)).append('.').append(signMegaPlayUrl$lambda$0$b64(sig)).toString();
            obj = Result.constructor-impl(url + (StringsKt.contains$default(url, "?", false, 2, (Object) null) ? "&" : "?") + "token=" + token);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = url;
        }
        return (String) obj;
    }

    private static final String signMegaPlayUrl$lambda$0$b64(byte[] b) {
        return StringsKt.replace$default(StringsKt.replace$default(Base64.getEncoder().withoutPadding().encodeToString(b), '+', '-', false, 4, (Object) null), '/', '_', false, 4, (Object) null);
    }

    private final String decryptMegaPlaySources(String enc) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            MegaPlay megaPlay = this;
            String normalized = StringsKt.replace$default(StringsKt.replace$default(enc, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
            String padded = normalized + StringsKt.repeat("=", (4 - (normalized.length() % 4)) % 4);
            byte[] data = Base64.getDecoder().decode(padded);
            byte[] keyBytes = ENC_KEY.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(keyBytes, "getBytes(...)");
            byte[] key = ArraysKt.plus(keyBytes, new byte[32 - keyBytes.length]);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            byte[] bytes = ENC_IV.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bytes));
            String json = new String(cipher.doFinal(data), Charsets.UTF_8);
            JSONObject el = new JSONObject(json);
            String it = el.optString("file");
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            obj = Result.constructor-impl(it);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010 Jn\u0010)\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0006HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/phisher98/MegaPlay$MegaPlayResponse;", "", "sources", "", "Lcom/phisher98/MegaPlay$Source;", "enc", "", "tracks", "Lcom/phisher98/MegaPlay$Track;", "encrypted", "", "intro", "Lcom/phisher98/MegaPlay$Intro;", "outro", "Lcom/phisher98/MegaPlay$Outro;", "server", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lcom/phisher98/MegaPlay$Intro;Lcom/phisher98/MegaPlay$Outro;Ljava/lang/Long;)V", "getSources", "()Ljava/util/List;", "getEnc", "()Ljava/lang/String;", "getTracks", "getEncrypted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIntro", "()Lcom/phisher98/MegaPlay$Intro;", "getOutro", "()Lcom/phisher98/MegaPlay$Outro;", "getServer", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Lcom/phisher98/MegaPlay$Intro;Lcom/phisher98/MegaPlay$Outro;Ljava/lang/Long;)Lcom/phisher98/MegaPlay$MegaPlayResponse;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MegaPlayResponse {

        @Nullable
        private final String enc;

        @Nullable
        private final Boolean encrypted;

        @Nullable
        private final Intro intro;

        @Nullable
        private final Outro outro;

        @Nullable
        private final Long server;

        @Nullable
        private final List<Source> sources;

        @Nullable
        private final List<Track> tracks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MegaPlayResponse copy$default(MegaPlayResponse megaPlayResponse, List list, String str, List list2, Boolean bool, Intro intro, Outro outro, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                list = megaPlayResponse.sources;
            }
            if ((i & 2) != 0) {
                str = megaPlayResponse.enc;
            }
            if ((i & 4) != 0) {
                list2 = megaPlayResponse.tracks;
            }
            if ((i & 8) != 0) {
                bool = megaPlayResponse.encrypted;
            }
            if ((i & 16) != 0) {
                intro = megaPlayResponse.intro;
            }
            if ((i & 32) != 0) {
                outro = megaPlayResponse.outro;
            }
            if ((i & 64) != 0) {
                l = megaPlayResponse.server;
            }
            Outro outro2 = outro;
            Long l2 = l;
            Intro intro2 = intro;
            List list3 = list2;
            return megaPlayResponse.copy(list, str, list3, bool, intro2, outro2, l2);
        }

        @Nullable
        public final List<Source> component1() {
            return this.sources;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEnc() {
            return this.enc;
        }

        @Nullable
        public final List<Track> component3() {
            return this.tracks;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getEncrypted() {
            return this.encrypted;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Intro getIntro() {
            return this.intro;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Outro getOutro() {
            return this.outro;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getServer() {
            return this.server;
        }

        @NotNull
        public final MegaPlayResponse copy(@Nullable List<Source> sources, @Nullable String enc, @Nullable List<Track> tracks, @Nullable Boolean encrypted, @Nullable Intro intro, @Nullable Outro outro, @Nullable Long server) {
            return new MegaPlayResponse(sources, enc, tracks, encrypted, intro, outro, server);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MegaPlayResponse)) {
                return false;
            }
            MegaPlayResponse megaPlayResponse = (MegaPlayResponse) other;
            return Intrinsics.areEqual(this.sources, megaPlayResponse.sources) && Intrinsics.areEqual(this.enc, megaPlayResponse.enc) && Intrinsics.areEqual(this.tracks, megaPlayResponse.tracks) && Intrinsics.areEqual(this.encrypted, megaPlayResponse.encrypted) && Intrinsics.areEqual(this.intro, megaPlayResponse.intro) && Intrinsics.areEqual(this.outro, megaPlayResponse.outro) && Intrinsics.areEqual(this.server, megaPlayResponse.server);
        }

        public int hashCode() {
            return ((((((((((((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.enc == null ? 0 : this.enc.hashCode())) * 31) + (this.tracks == null ? 0 : this.tracks.hashCode())) * 31) + (this.encrypted == null ? 0 : this.encrypted.hashCode())) * 31) + (this.intro == null ? 0 : this.intro.hashCode())) * 31) + (this.outro == null ? 0 : this.outro.hashCode())) * 31) + (this.server != null ? this.server.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "MegaPlayResponse(sources=" + this.sources + ", enc=" + this.enc + ", tracks=" + this.tracks + ", encrypted=" + this.encrypted + ", intro=" + this.intro + ", outro=" + this.outro + ", server=" + this.server + ')';
        }

        public MegaPlayResponse(@Nullable List<Source> list, @Nullable String enc, @Nullable List<Track> list2, @Nullable Boolean encrypted, @Nullable Intro intro, @Nullable Outro outro, @Nullable Long server) {
            this.sources = list;
            this.enc = enc;
            this.tracks = list2;
            this.encrypted = encrypted;
            this.intro = intro;
            this.outro = outro;
            this.server = server;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ MegaPlayResponse(List list, String str, List list2, Boolean bool, Intro intro, Outro outro, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str2;
            if ((i & 2) == 0) {
                str2 = str;
            } else {
                str2 = null;
            }
            this(list, str2, list2, bool, intro, outro, l);
        }

        @Nullable
        public final List<Source> getSources() {
            return this.sources;
        }

        @Nullable
        public final String getEnc() {
            return this.enc;
        }

        @Nullable
        public final List<Track> getTracks() {
            return this.tracks;
        }

        @Nullable
        public final Boolean getEncrypted() {
            return this.encrypted;
        }

        @Nullable
        public final Intro getIntro() {
            return this.intro;
        }

        @Nullable
        public final Outro getOutro() {
            return this.outro;
        }

        @Nullable
        public final Long getServer() {
            return this.server;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/MegaPlay$Source;", "", "file", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Source {

        @Nullable
        private final String file;

        @Nullable
        private final String type;

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.file;
            }
            if ((i & 2) != 0) {
                str2 = source.type;
            }
            return source.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Source copy(@Nullable String file, @Nullable String type) {
            return new Source(file, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics.areEqual(this.file, source.file) && Intrinsics.areEqual(this.type, source.type);
        }

        public int hashCode() {
            return ((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Source(file=" + this.file + ", type=" + this.type + ')';
        }

        public Source(@Nullable String file, @Nullable String type) {
            this.file = file;
            this.type = type;
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/phisher98/MegaPlay$Track;", "", "file", "", "label", "kind", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/phisher98/MegaPlay$Track;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Track {

        @Nullable
        private final Boolean default;

        @Nullable
        private final String file;

        @Nullable
        private final String kind;

        @Nullable
        private final String label;

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                str3 = track.kind;
            }
            if ((i & 8) != 0) {
                bool = track.default;
            }
            return track.copy(str, str2, str3, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getDefault() {
            return this.default;
        }

        @NotNull
        public final Track copy(@Nullable String file, @Nullable String label, @Nullable String kind, @Nullable Boolean bool) {
            return new Track(file, label, kind, bool);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind) && Intrinsics.areEqual(this.default, track.default);
        }

        public int hashCode() {
            return ((((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind == null ? 0 : this.kind.hashCode())) * 31) + (this.default != null ? this.default.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ", default=" + this.default + ')';
        }

        public Track(@Nullable String file, @Nullable String label, @Nullable String kind, @Nullable Boolean bool) {
            this.file = file;
            this.label = label;
            this.kind = kind;
            this.default = bool;
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getKind() {
            return this.kind;
        }

        @Nullable
        public final Boolean getDefault() {
            return this.default;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/MegaPlay$Intro;", "", "start", "", "end", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnd", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/phisher98/MegaPlay$Intro;", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Intro {

        @Nullable
        private final Long end;

        @Nullable
        private final Long start;

        public static /* synthetic */ Intro copy$default(Intro intro, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = intro.start;
            }
            if ((i & 2) != 0) {
                l2 = intro.end;
            }
            return intro.copy(l, l2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getEnd() {
            return this.end;
        }

        @NotNull
        public final Intro copy(@Nullable Long start, @Nullable Long end) {
            return new Intro(start, end);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Intro)) {
                return false;
            }
            Intro intro = (Intro) other;
            return Intrinsics.areEqual(this.start, intro.start) && Intrinsics.areEqual(this.end, intro.end);
        }

        public int hashCode() {
            return ((this.start == null ? 0 : this.start.hashCode()) * 31) + (this.end != null ? this.end.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Intro(start=" + this.start + ", end=" + this.end + ')';
        }

        public Intro(@Nullable Long start, @Nullable Long end) {
            this.start = start;
            this.end = end;
        }

        @Nullable
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        public final Long getEnd() {
            return this.end;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/MegaPlay$Outro;", "", "start", "", "end", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnd", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/phisher98/MegaPlay$Outro;", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Outro {

        @Nullable
        private final Long end;

        @Nullable
        private final Long start;

        public static /* synthetic */ Outro copy$default(Outro outro, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = outro.start;
            }
            if ((i & 2) != 0) {
                l2 = outro.end;
            }
            return outro.copy(l, l2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getEnd() {
            return this.end;
        }

        @NotNull
        public final Outro copy(@Nullable Long start, @Nullable Long end) {
            return new Outro(start, end);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Outro)) {
                return false;
            }
            Outro outro = (Outro) other;
            return Intrinsics.areEqual(this.start, outro.start) && Intrinsics.areEqual(this.end, outro.end);
        }

        public int hashCode() {
            return ((this.start == null ? 0 : this.start.hashCode()) * 31) + (this.end != null ? this.end.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Outro(start=" + this.start + ", end=" + this.end + ')';
        }

        public Outro(@Nullable Long start, @Nullable Long end) {
            this.start = start;
            this.end = end;
        }

        @Nullable
        public final Long getStart() {
            return this.start;
        }

        @Nullable
        public final Long getEnd() {
            return this.end;
        }
    }
}
