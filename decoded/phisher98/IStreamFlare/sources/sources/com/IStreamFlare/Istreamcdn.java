package com.IStreamFlare;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IStreamFlare/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0011JH\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/IStreamFlare/Istreamcdn;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "resolveCdnRedirect", "phpUrl", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUrl", "", "url", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Istreamcdn extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "IStreamCDN";

    @NotNull
    private final String mainUrl = "https://istreamcdn.com";

    /* JADX INFO: renamed from: com.IStreamFlare.Istreamcdn$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.Istreamcdn", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {80, 94}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "parsedUrl", "host", "qualityName", "$this", "url", "referer", "subtitleCallback", "callback", "parsedUrl", "host", "qualityName", "streamUrl", "type"}, nl = {81, 93}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Istreamcdn.getUrl$suspendImpl(Istreamcdn.this, null, null, null, null, (Continuation) this);
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

    /* JADX INFO: renamed from: com.IStreamFlare.Istreamcdn$resolveCdnRedirect$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.Istreamcdn$resolveCdnRedirect$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/IStreamFlare/Istreamcdn$resolveCdnRedirect$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n1#2:115\n*E\n"})
    static final class C00122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $phpUrl;
        final /* synthetic */ String $referer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00122(String str, String str2, Continuation<? super C00122> continuation) {
            super(2, continuation);
            this.$phpUrl = str;
            this.$referer = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00122(this.$phpUrl, this.$referer, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String location;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    HttpURLConnection conn = null;
                    String str = null;
                    try {
                        URLConnection uRLConnectionOpenConnection = new URL(this.$phpUrl).openConnection();
                        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        conn = (HttpURLConnection) uRLConnectionOpenConnection;
                        conn.setInstanceFollowRedirects(false);
                        conn.setConnectTimeout(15000);
                        conn.setReadTimeout(15000);
                        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, likе Gecko) Chrome/120.0.0.0 Safari/537.36");
                        conn.setRequestProperty("Referer", this.$referer);
                        conn.setRequestProperty("Accept-Encoding", "gzip");
                        conn.connect();
                        int code = conn.getResponseCode();
                        if ((300 <= code && code < 400) && (location = conn.getHeaderField("Location")) != null && StringsKt.startsWith$default(location, "http", false, 2, (Object) null)) {
                            str = location;
                        }
                    } catch (Exception e) {
                        if (conn != null) {
                        }
                        return str;
                    } catch (Throwable th) {
                        if (conn != null) {
                            conn.disconnect();
                        }
                        throw th;
                    }
                    conn.disconnect();
                    return str;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object resolveCdnRedirect(String phpUrl, String referer, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00122(phpUrl, referer, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0118  */
    /* JADX WARN: Code duplicated, block: B:42:0x013f A[Catch: all -> 0x020f, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x020f, blocks: (B:34:0x0114, B:42:0x013f, B:47:0x0153, B:56:0x0177, B:51:0x0164, B:55:0x0175), top: B:103:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x014f A[Catch: all -> 0x0135, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0135, blocks: (B:37:0x011a, B:44:0x014f, B:49:0x0161, B:53:0x0172), top: B:94:0x0116 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0153 A[Catch: all -> 0x020f, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x020f, blocks: (B:34:0x0114, B:42:0x013f, B:47:0x0153, B:56:0x0177, B:51:0x0164, B:55:0x0175), top: B:103:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    static /* synthetic */ Object getUrl$suspendImpl(Istreamcdn $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00101 c00101;
        String qualityName;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String qualityName2;
        String qualityName3;
        Object obj;
        URL parsedUrl;
        String streamUrl;
        ExtractorLinkType type;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        Istreamcdn $this2 = $this;
        String url2 = url;
        String referer2 = referer;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = $this2.new C00101(continuation);
            }
        } else {
            c00101 = $this2.new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                URL parsedUrl2 = new URL(url2);
                String host = parsedUrl2.getProtocol() + "://" + parsedUrl2.getHost();
                if (referer2 == null || (qualityName = StringsKt.substringBefore$default(referer2, "+", (String) null, 2, (Object) null)) == null) {
                    qualityName = "";
                }
                try {
                    c00102.L$0 = $this2;
                    c00102.L$1 = url2;
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    function4 = function2;
                    try {
                        c00102.L$4 = function4;
                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(parsedUrl2);
                        c00102.L$6 = host;
                        c00102.L$7 = qualityName;
                        c00102.label = 1;
                        Object objResolveCdnRedirect = $this2.resolveCdnRedirect(url2, host, c00102);
                        if (objResolveCdnRedirect == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        qualityName2 = qualityName;
                        qualityName3 = host;
                        obj = objResolveCdnRedirect;
                        function3 = function1;
                        parsedUrl = parsedUrl2;
                        try {
                            streamUrl = (String) obj;
                            try {
                                if (streamUrl == null) {
                                    Log.INSTANCE.e("IStreamCDN", "No redirect Location from " + url2);
                                    return Unit.INSTANCE;
                                }
                                if (StringsKt.contains(streamUrl, "sub_expire", true)) {
                                    return Unit.INSTANCE;
                                }
                                type = (StringsKt.contains(streamUrl, ".mpd", true) && StringsKt.contains(streamUrl, ".m3u8", true)) ? ExtractorLinkType.M3U8 : ExtractorLinkType.DASH;
                                ExtractorLinkType type2 = type;
                                String name = $this2.getName();
                                String host2 = $this2.getName();
                                Istreamcdn $this3 = $this2;
                                try {
                                    String url3 = url2;
                                    try {
                                        C00112 c00112 = new C00112(qualityName3, qualityName2, null);
                                        c00102.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                                        c00102.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                                        c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                                        c00102.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                        c00102.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(parsedUrl);
                                        c00102.L$6 = SpillingKt.nullOutSpilledVariable(qualityName3);
                                        c00102.L$7 = SpillingKt.nullOutSpilledVariable(qualityName2);
                                        c00102.L$8 = SpillingKt.nullOutSpilledVariable(streamUrl);
                                        c00102.L$9 = SpillingKt.nullOutSpilledVariable(type2);
                                        c00102.L$10 = function4;
                                        c00102.label = 2;
                                        try {
                                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(host2, name, streamUrl, type2, c00112, c00102);
                                            if (objNewExtractorLink == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            function5 = function4;
                                            function6 = function3;
                                            try {
                                                function5.invoke(objNewExtractorLink);
                                                break;
                                            } catch (Throwable th) {
                                                function3 = function6;
                                                Log.INSTANCE.e("IStreamCDN", "getUrl failed");
                                            }
                                            return Unit.INSTANCE;
                                        } catch (Throwable th2) {
                                        }
                                    } catch (Throwable th3) {
                                    }
                                } catch (Throwable th4) {
                                }
                            } catch (Throwable th5) {
                            }
                        } catch (Throwable th6) {
                        }
                        Log.INSTANCE.e("IStreamCDN", "getUrl failed");
                        return Unit.INSTANCE;
                    } catch (Throwable th7) {
                        function3 = function1;
                    }
                } catch (Throwable th8) {
                }
                break;
            case 1:
                String qualityName4 = (String) c00102.L$7;
                String host3 = (String) c00102.L$6;
                URL parsedUrl3 = (URL) c00102.L$5;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00102.L$4;
                function3 = (Function1) c00102.L$3;
                referer2 = (String) c00102.L$2;
                url2 = (String) c00102.L$1;
                $this2 = (Istreamcdn) c00102.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    parsedUrl = parsedUrl3;
                    function4 = function7;
                    qualityName2 = qualityName4;
                    qualityName3 = host3;
                    streamUrl = (String) obj;
                    if (streamUrl == null) {
                        Log.INSTANCE.e("IStreamCDN", "No redirect Location from " + url2);
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains(streamUrl, "sub_expire", true)) {
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains(streamUrl, ".mpd", true)) {
                        type = ExtractorLinkType.DASH;
                    }
                    ExtractorLinkType type3 = type;
                    String name2 = $this2.getName();
                    String host4 = $this2.getName();
                    Istreamcdn $this4 = $this2;
                    String url4 = url2;
                    C00112 c00113 = new C00112(qualityName3, qualityName2, null);
                    c00102.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    c00102.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(parsedUrl);
                    c00102.L$6 = SpillingKt.nullOutSpilledVariable(qualityName3);
                    c00102.L$7 = SpillingKt.nullOutSpilledVariable(qualityName2);
                    c00102.L$8 = SpillingKt.nullOutSpilledVariable(streamUrl);
                    c00102.L$9 = SpillingKt.nullOutSpilledVariable(type3);
                    c00102.L$10 = function4;
                    c00102.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(host4, name2, streamUrl, type3, c00113, c00102);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function4;
                    function6 = function3;
                    function5.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                } catch (Throwable th9) {
                }
                Log.INSTANCE.e("IStreamCDN", "getUrl failed");
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c00102.L$10;
                function6 = (Function1) c00102.L$3;
                try {
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    function5.invoke(objNewExtractorLink);
                    break;
                } catch (Throwable th10) {
                    function3 = function6;
                    break;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.IStreamFlare.Istreamcdn$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.IStreamFlare.Istreamcdn$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $host;
        final /* synthetic */ String $qualityName;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(String str, String str2, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$host = str;
            this.$qualityName = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = new C00112(this.$host, this.$qualityName, continuation);
            c00112.L$0 = obj;
            return c00112;
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
                    $this$newExtractorLink.setReferer(this.$host);
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$qualityName));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, likе Gecko) Chrome/120.0.0.0 Safari/537.36"), TuplesKt.to("Referer", this.$host)}));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
