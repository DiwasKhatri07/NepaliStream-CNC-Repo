package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.network.WebViewResolver;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Vidora;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Vidora\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2,2:4004\n2068#2,2:4006\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Vidora\n*L\n2458#1:4004,2\n2479#1:4006,2\n*E\n"})
public final class Vidora extends ExtractorApi {

    @NotNull
    private final String name = "Vidora";

    @NotNull
    private final String mainUrl = "https://vidora.stream";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Vidora$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Vidora", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {2427, 2432, 2453, 2468, 2475}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "embedUrl", "url", "referer", "subtitleCallback", "callback", "embedUrl", "pageResponse", "iframeElement", "iframeUrl", "url", "referer", "subtitleCallback", "callback", "embedUrl", "pageResponse", "iframeElement", "headers", "scriptData", "m3u8Url", "url", "referer", "subtitleCallback", "callback", "embedUrl", "pageResponse", "iframeElement", "headers", "scriptData", "m3u8Url", "resolver", "url", "referer", "subtitleCallback", "callback", "embedUrl", "pageResponse", "iframeElement", "headers", "scriptData", "m3u8Url", "resolver", "interceptedUrl"}, nl = {2429, 2441, 2458, 2472, 2479}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C03101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        C03101(Continuation<? super C03101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Vidora.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:23:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:25:0x0245 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0246  */
    /* JADX WARN: Code duplicated, block: B:28:0x0264  */
    /* JADX WARN: Code duplicated, block: B:31:0x0297  */
    /* JADX WARN: Code duplicated, block: B:35:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:38:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:39:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:41:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:42:0x02be  */
    /* JADX WARN: Code duplicated, block: B:45:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:50:0x02e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:53:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:57:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:59:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:61:0x0350 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0351  */
    /* JADX WARN: Code duplicated, block: B:66:0x0372 A[LOOP:1: B:64:0x036c->B:66:0x0372, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x037d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0422 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0423  */
    /* JADX WARN: Code duplicated, block: B:74:0x0439  */
    /* JADX WARN: Code duplicated, block: B:75:0x043b  */
    /* JADX WARN: Code duplicated, block: B:77:0x043e  */
    /* JADX WARN: Code duplicated, block: B:79:0x049c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x049d  */
    /* JADX WARN: Code duplicated, block: B:84:0x04bb A[LOOP:0: B:82:0x04b5->B:84:0x04bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:86:0x04d5  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C03101 c03101;
        Vidora vidora;
        char c;
        Object obj;
        int i;
        String url2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        String embedUrl;
        String referer2;
        Function1<? super ExtractorLink, Unit> function4;
        NiceResponse pageResponse;
        Element iframeElement;
        String referer3;
        Element iframeElement2;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        String referer4;
        Object obj3;
        String url3;
        Function1<? super SubtitleFile, Unit> function7;
        String embedUrl2;
        Element iframeElement3;
        String referer5;
        Function1<? super ExtractorLink, Unit> function8;
        Map headers;
        String packed;
        boolean z;
        String m3u8Url;
        Element elementSelectFirst;
        String strData;
        String scriptData;
        String str;
        boolean z2;
        String m3u8Url2;
        Map headers2;
        WebViewResolver resolver;
        Function1<? super ExtractorLink, Unit> function9;
        String referer6;
        Object obj4;
        Function1<? super ExtractorLink, Unit> function10;
        Function1<? super SubtitleFile, Unit> function11;
        String embedUrl3;
        String $result;
        Function1<? super ExtractorLink, Unit> function12;
        MatchResult matchResultFind$default;
        List groupValues;
        String interceptedUrl;
        boolean z3;
        Object objGenerateM3u8$default;
        String embedUrl4;
        Function1<? super ExtractorLink, Unit> function13;
        Function1<? super SubtitleFile, Unit> function14;
        String url4;
        String scriptData2;
        NiceResponse pageResponse2;
        Element iframeElement4;
        Map headers3;
        String referer7;
        int $i$f$forEach;
        if (continuation instanceof C03101) {
            c03101 = (C03101) continuation;
            if ((c03101.label & Integer.MIN_VALUE) != 0) {
                c03101.label -= Integer.MIN_VALUE;
                vidora = this;
            } else {
                vidora = this;
                c03101 = vidora.new C03101(continuation);
            }
        } else {
            vidora = this;
            c03101 = vidora.new C03101(continuation);
        }
        C03101 c03102 = c03101;
        Object $result2 = c03102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03102.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                String embedUrl5 = StringsKt.replace$default(url, "/download/", "/e/", false, 4, (Object) null);
                Requests app = MainActivityKt.getApp();
                c03102.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c03102.L$1 = referer;
                c03102.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c03102.L$3 = function2;
                c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl5);
                c03102.label = 1;
                c = 0;
                obj = coroutine_suspended;
                i = 2;
                Object obj5 = Requests.get$default(app, embedUrl5, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03102, 4090, (Object) null);
                c03102 = c03102;
                if (obj5 == obj) {
                    return obj;
                }
                url2 = url;
                function3 = function1;
                obj2 = obj5;
                embedUrl = embedUrl5;
                referer2 = referer;
                function4 = function2;
                pageResponse = (NiceResponse) obj2;
                iframeElement = pageResponse.getDocument().selectFirst("iframe");
                if (iframeElement != null) {
                    String iframeUrl = iframeElement.attr("src");
                    Requests app2 = MainActivityKt.getApp();
                    Pair[] pairArr = new Pair[i];
                    pairArr[c] = TuplesKt.to("Accept-Language", "en-US,en;q=0.5");
                    pairArr[1] = TuplesKt.to("Sec-Fetch-Dest", "iframe");
                    Map mapMapOf = MapsKt.mapOf(pairArr);
                    String url5 = pageResponse.getUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = referer2;
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c03102.L$3 = function4;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                    c03102.label = i;
                    function6 = function4;
                    referer4 = referer2;
                    C03101 c03103 = c03102;
                    obj3 = Requests.get$default(app2, iframeUrl, mapMapOf, url5, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03103, 4088, (Object) null);
                    c03102 = c03103;
                    if (obj3 == obj) {
                        return obj;
                    }
                    url3 = url2;
                    function7 = function3;
                    embedUrl2 = embedUrl;
                    iframeElement3 = iframeElement;
                    referer5 = referer4;
                    function8 = function6;
                    pageResponse = (NiceResponse) obj3;
                    iframeElement2 = iframeElement3;
                    embedUrl = embedUrl2;
                    function3 = function7;
                    referer3 = referer5;
                    url2 = url3;
                    function5 = function8;
                } else {
                    referer3 = referer2;
                    iframeElement2 = iframeElement;
                    function5 = function4;
                }
                Pair[] pairArr2 = new Pair[i];
                pairArr2[c] = TuplesKt.to("origin", vidora.getMainUrl());
                pairArr2[1] = TuplesKt.to("referer", vidora.getMainUrl());
                headers = MapsKt.mapOf(pairArr2);
                packed = ExtractorApiKt.getPacked(pageResponse.getText());
                if (packed != null || packed.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                m3u8Url = null;
                if (z) {
                    elementSelectFirst = pageResponse.getDocument().selectFirst("script:containsData(sources:)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                } else {
                    strData = ExtractorApiKt.getAndUnpack(pageResponse.getText());
                }
                scriptData = strData;
                if (scriptData == null && (matchResultFind$default = Regex.find$default(new Regex("file:\\s*\"(.*?m3u8.*?)\""), scriptData, 0, i, (Object) null)) != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    m3u8Url = (String) CollectionsKt.getOrNull(groupValues, 1);
                }
                str = m3u8Url;
                if (str != null || str.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    String m3u8Url3 = m3u8Url;
                    M3u8Helper.Companion companion = M3u8Helper.Companion;
                    String name = vidora.getName();
                    String mainUrl = vidora.getMainUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c03102.L$3 = function5;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers);
                    c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                    c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url3);
                    c03102.label = 3;
                    $result2 = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8Url3, mainUrl, (Integer) null, headers, (String) null, c03102, 40, (Object) null);
                    if ($result2 == obj) {
                        return obj;
                    }
                    function12 = function5;
                    Iterable $this$forEach$iv = (Iterable) $result2;
                    for (Object element$iv : $this$forEach$iv) {
                        function12.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                }
                m3u8Url2 = m3u8Url;
                headers2 = headers;
                resolver = new WebViewResolver(new Regex("(m3u8|master\\.txt)"), CollectionsKt.listOf(new Regex("(m3u8|master\\.txt)")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c03102.L$3 = function5;
                c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                c03102.L$10 = SpillingKt.nullOutSpilledVariable(resolver);
                c03102.label = 4;
                C03101 c03104 = c03102;
                function9 = function5;
                referer6 = referer3;
                obj4 = Requests.get$default(MainActivityKt.getApp(), pageResponse.getUrl(), (Map) null, referer6, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) resolver, false, (ResponseParser) null, c03104, 3578, (Object) null);
                c03102 = c03104;
                if (obj4 == obj) {
                    return obj;
                }
                function10 = function9;
                function11 = function3;
                embedUrl3 = embedUrl;
                $result = referer6;
                interceptedUrl = ((NiceResponse) obj4).getUrl();
                if (interceptedUrl.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                    String name2 = vidora.getName();
                    String mainUrl2 = vidora.getMainUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = SpillingKt.nullOutSpilledVariable($result);
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                    c03102.L$3 = function10;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl3);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                    c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                    c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                    c03102.L$10 = SpillingKt.nullOutSpilledVariable(resolver);
                    c03102.L$11 = SpillingKt.nullOutSpilledVariable(interceptedUrl);
                    c03102.label = 5;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion2, name2, interceptedUrl, mainUrl2, (Integer) null, (Map) null, (String) null, c03102, 56, (Object) null);
                    if (objGenerateM3u8$default == obj) {
                        return obj;
                    }
                    embedUrl4 = embedUrl3;
                    function13 = function10;
                    function14 = function11;
                    url4 = url2;
                    scriptData2 = scriptData;
                    pageResponse2 = pageResponse;
                    iframeElement4 = iframeElement2;
                    headers3 = headers2;
                    referer7 = $result;
                    Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                    $i$f$forEach = 0;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        int $i$f$forEach2 = $i$f$forEach;
                        function13.invoke(element$iv2);
                        $i$f$forEach = $i$f$forEach2;
                    }
                } else {
                    Log.INSTANCE.d("Filesim", "No m3u8 found via script or WebView fallback.");
                }
                return Unit.INSTANCE;
            case 1:
                String embedUrl6 = (String) c03102.L$4;
                Function1<? super ExtractorLink, Unit> function15 = (Function1) c03102.L$3;
                Function1<? super SubtitleFile, Unit> function16 = (Function1) c03102.L$2;
                String referer8 = (String) c03102.L$1;
                String url6 = (String) c03102.L$0;
                ResultKt.throwOnFailure($result2);
                obj2 = $result2;
                obj = coroutine_suspended;
                embedUrl = embedUrl6;
                function4 = function15;
                function3 = function16;
                referer2 = referer8;
                url2 = url6;
                i = 2;
                c = 0;
                pageResponse = (NiceResponse) obj2;
                iframeElement = pageResponse.getDocument().selectFirst("iframe");
                if (iframeElement != null) {
                    String iframeUrl2 = iframeElement.attr("src");
                    Requests app3 = MainActivityKt.getApp();
                    Pair[] pairArr3 = new Pair[i];
                    pairArr3[c] = TuplesKt.to("Accept-Language", "en-US,en;q=0.5");
                    pairArr3[1] = TuplesKt.to("Sec-Fetch-Dest", "iframe");
                    Map mapMapOf2 = MapsKt.mapOf(pairArr3);
                    String url7 = pageResponse.getUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = referer2;
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c03102.L$3 = function4;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(iframeUrl2);
                    c03102.label = i;
                    function6 = function4;
                    referer4 = referer2;
                    C03101 c03105 = c03102;
                    obj3 = Requests.get$default(app3, iframeUrl2, mapMapOf2, url7, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03105, 4088, (Object) null);
                    c03102 = c03105;
                    if (obj3 == obj) {
                        return obj;
                    }
                    url3 = url2;
                    function7 = function3;
                    embedUrl2 = embedUrl;
                    iframeElement3 = iframeElement;
                    referer5 = referer4;
                    function8 = function6;
                    pageResponse = (NiceResponse) obj3;
                    iframeElement2 = iframeElement3;
                    embedUrl = embedUrl2;
                    function3 = function7;
                    referer3 = referer5;
                    url2 = url3;
                    function5 = function8;
                } else {
                    referer3 = referer2;
                    iframeElement2 = iframeElement;
                    function5 = function4;
                }
                Pair[] pairArr4 = new Pair[i];
                pairArr4[c] = TuplesKt.to("origin", vidora.getMainUrl());
                pairArr4[1] = TuplesKt.to("referer", vidora.getMainUrl());
                headers = MapsKt.mapOf(pairArr4);
                packed = ExtractorApiKt.getPacked(pageResponse.getText());
                if (packed != null) {
                    z = true;
                } else {
                    z = true;
                }
                m3u8Url = null;
                if (z) {
                    strData = ExtractorApiKt.getAndUnpack(pageResponse.getText());
                } else {
                    elementSelectFirst = pageResponse.getDocument().selectFirst("script:containsData(sources:)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                }
                scriptData = strData;
                if (scriptData == null) {
                    m3u8Url = (String) CollectionsKt.getOrNull(groupValues, 1);
                }
                str = m3u8Url;
                if (str != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    String m3u8Url4 = m3u8Url;
                    M3u8Helper.Companion companion3 = M3u8Helper.Companion;
                    String name3 = vidora.getName();
                    String mainUrl3 = vidora.getMainUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c03102.L$3 = function5;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers);
                    c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                    c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url4);
                    c03102.label = 3;
                    $result2 = M3u8Helper.Companion.generateM3u8$default(companion3, name3, m3u8Url4, mainUrl3, (Integer) null, headers, (String) null, c03102, 40, (Object) null);
                    if ($result2 == obj) {
                        return obj;
                    }
                    function12 = function5;
                    Iterable $this$forEach$iv3 = (Iterable) $result2;
                    while (r14.hasNext()) {
                        function12.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                }
                m3u8Url2 = m3u8Url;
                headers2 = headers;
                resolver = new WebViewResolver(new Regex("(m3u8|master\\.txt)"), CollectionsKt.listOf(new Regex("(m3u8|master\\.txt)")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c03102.L$3 = function5;
                c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                c03102.L$10 = SpillingKt.nullOutSpilledVariable(resolver);
                c03102.label = 4;
                C03101 c03106 = c03102;
                function9 = function5;
                referer6 = referer3;
                obj4 = Requests.get$default(MainActivityKt.getApp(), pageResponse.getUrl(), (Map) null, referer6, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) resolver, false, (ResponseParser) null, c03106, 3578, (Object) null);
                c03102 = c03106;
                if (obj4 == obj) {
                    return obj;
                }
                function10 = function9;
                function11 = function3;
                embedUrl3 = embedUrl;
                $result = referer6;
                interceptedUrl = ((NiceResponse) obj4).getUrl();
                if (interceptedUrl.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    M3u8Helper.Companion companion4 = M3u8Helper.Companion;
                    String name4 = vidora.getName();
                    String mainUrl4 = vidora.getMainUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = SpillingKt.nullOutSpilledVariable($result);
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                    c03102.L$3 = function10;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl3);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                    c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                    c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                    c03102.L$10 = SpillingKt.nullOutSpilledVariable(resolver);
                    c03102.L$11 = SpillingKt.nullOutSpilledVariable(interceptedUrl);
                    c03102.label = 5;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion4, name4, interceptedUrl, mainUrl4, (Integer) null, (Map) null, (String) null, c03102, 56, (Object) null);
                    if (objGenerateM3u8$default == obj) {
                        return obj;
                    }
                    embedUrl4 = embedUrl3;
                    function13 = function10;
                    function14 = function11;
                    url4 = url2;
                    scriptData2 = scriptData;
                    pageResponse2 = pageResponse;
                    iframeElement4 = iframeElement2;
                    headers3 = headers2;
                    referer7 = $result;
                    Iterable $this$forEach$iv4 = (Iterable) objGenerateM3u8$default;
                    $i$f$forEach = 0;
                    while (r1.hasNext()) {
                        int $i$f$forEach3 = $i$f$forEach;
                        function13.invoke(element$iv2);
                        $i$f$forEach = $i$f$forEach3;
                    }
                } else {
                    Log.INSTANCE.d("Filesim", "No m3u8 found via script or WebView fallback.");
                }
                return Unit.INSTANCE;
            case 2:
                iframeElement3 = (Element) c03102.L$6;
                embedUrl2 = (String) c03102.L$4;
                function8 = (Function1) c03102.L$3;
                function7 = (Function1) c03102.L$2;
                referer5 = (String) c03102.L$1;
                url3 = (String) c03102.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                c = 0;
                obj3 = $result2;
                i = 2;
                pageResponse = (NiceResponse) obj3;
                iframeElement2 = iframeElement3;
                embedUrl = embedUrl2;
                function3 = function7;
                referer3 = referer5;
                url2 = url3;
                function5 = function8;
                Pair[] pairArr5 = new Pair[i];
                pairArr5[c] = TuplesKt.to("origin", vidora.getMainUrl());
                pairArr5[1] = TuplesKt.to("referer", vidora.getMainUrl());
                headers = MapsKt.mapOf(pairArr5);
                packed = ExtractorApiKt.getPacked(pageResponse.getText());
                if (packed != null) {
                    z = true;
                } else {
                    z = true;
                }
                m3u8Url = null;
                if (z) {
                    strData = ExtractorApiKt.getAndUnpack(pageResponse.getText());
                } else {
                    elementSelectFirst = pageResponse.getDocument().selectFirst("script:containsData(sources:)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                }
                scriptData = strData;
                if (scriptData == null) {
                    m3u8Url = (String) CollectionsKt.getOrNull(groupValues, 1);
                }
                str = m3u8Url;
                if (str != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    String m3u8Url5 = m3u8Url;
                    M3u8Helper.Companion companion5 = M3u8Helper.Companion;
                    String name5 = vidora.getName();
                    String mainUrl5 = vidora.getMainUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c03102.L$3 = function5;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers);
                    c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                    c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url5);
                    c03102.label = 3;
                    $result2 = M3u8Helper.Companion.generateM3u8$default(companion5, name5, m3u8Url5, mainUrl5, (Integer) null, headers, (String) null, c03102, 40, (Object) null);
                    if ($result2 == obj) {
                        return obj;
                    }
                    function12 = function5;
                    Iterable $this$forEach$iv5 = (Iterable) $result2;
                    while (r14.hasNext()) {
                        function12.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                }
                m3u8Url2 = m3u8Url;
                headers2 = headers;
                resolver = new WebViewResolver(new Regex("(m3u8|master\\.txt)"), CollectionsKt.listOf(new Regex("(m3u8|master\\.txt)")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03102.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c03102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c03102.L$3 = function5;
                c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl);
                c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                c03102.L$10 = SpillingKt.nullOutSpilledVariable(resolver);
                c03102.label = 4;
                C03101 c03107 = c03102;
                function9 = function5;
                referer6 = referer3;
                obj4 = Requests.get$default(MainActivityKt.getApp(), pageResponse.getUrl(), (Map) null, referer6, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) resolver, false, (ResponseParser) null, c03107, 3578, (Object) null);
                c03102 = c03107;
                if (obj4 == obj) {
                    return obj;
                }
                function10 = function9;
                function11 = function3;
                embedUrl3 = embedUrl;
                $result = referer6;
                interceptedUrl = ((NiceResponse) obj4).getUrl();
                if (interceptedUrl.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    M3u8Helper.Companion companion6 = M3u8Helper.Companion;
                    String name6 = vidora.getName();
                    String mainUrl6 = vidora.getMainUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = SpillingKt.nullOutSpilledVariable($result);
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                    c03102.L$3 = function10;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl3);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                    c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                    c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                    c03102.L$10 = SpillingKt.nullOutSpilledVariable(resolver);
                    c03102.L$11 = SpillingKt.nullOutSpilledVariable(interceptedUrl);
                    c03102.label = 5;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion6, name6, interceptedUrl, mainUrl6, (Integer) null, (Map) null, (String) null, c03102, 56, (Object) null);
                    if (objGenerateM3u8$default == obj) {
                        return obj;
                    }
                    embedUrl4 = embedUrl3;
                    function13 = function10;
                    function14 = function11;
                    url4 = url2;
                    scriptData2 = scriptData;
                    pageResponse2 = pageResponse;
                    iframeElement4 = iframeElement2;
                    headers3 = headers2;
                    referer7 = $result;
                    Iterable $this$forEach$iv6 = (Iterable) objGenerateM3u8$default;
                    $i$f$forEach = 0;
                    while (r1.hasNext()) {
                        int $i$f$forEach4 = $i$f$forEach;
                        function13.invoke(element$iv2);
                        $i$f$forEach = $i$f$forEach4;
                    }
                } else {
                    Log.INSTANCE.d("Filesim", "No m3u8 found via script or WebView fallback.");
                }
                return Unit.INSTANCE;
            case 3:
                function12 = (Function1) c03102.L$3;
                ResultKt.throwOnFailure($result2);
                Iterable $this$forEach$iv7 = (Iterable) $result2;
                while (r14.hasNext()) {
                    function12.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 4:
                WebViewResolver resolver2 = (WebViewResolver) c03102.L$10;
                String m3u8Url6 = (String) c03102.L$9;
                String scriptData3 = (String) c03102.L$8;
                Map headers4 = (Map) c03102.L$7;
                Element iframeElement5 = (Element) c03102.L$6;
                NiceResponse pageResponse3 = (NiceResponse) c03102.L$5;
                embedUrl3 = (String) c03102.L$4;
                function10 = (Function1) c03102.L$3;
                function11 = (Function1) c03102.L$2;
                String referer9 = (String) c03102.L$1;
                String url8 = (String) c03102.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                resolver = resolver2;
                m3u8Url2 = m3u8Url6;
                url2 = url8;
                scriptData = scriptData3;
                headers2 = headers4;
                iframeElement2 = iframeElement5;
                pageResponse = pageResponse3;
                obj4 = $result2;
                $result = referer9;
                interceptedUrl = ((NiceResponse) obj4).getUrl();
                if (interceptedUrl.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    M3u8Helper.Companion companion7 = M3u8Helper.Companion;
                    String name7 = vidora.getName();
                    String mainUrl7 = vidora.getMainUrl();
                    c03102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c03102.L$1 = SpillingKt.nullOutSpilledVariable($result);
                    c03102.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                    c03102.L$3 = function10;
                    c03102.L$4 = SpillingKt.nullOutSpilledVariable(embedUrl3);
                    c03102.L$5 = SpillingKt.nullOutSpilledVariable(pageResponse);
                    c03102.L$6 = SpillingKt.nullOutSpilledVariable(iframeElement2);
                    c03102.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                    c03102.L$8 = SpillingKt.nullOutSpilledVariable(scriptData);
                    c03102.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                    c03102.L$10 = SpillingKt.nullOutSpilledVariable(resolver);
                    c03102.L$11 = SpillingKt.nullOutSpilledVariable(interceptedUrl);
                    c03102.label = 5;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion7, name7, interceptedUrl, mainUrl7, (Integer) null, (Map) null, (String) null, c03102, 56, (Object) null);
                    if (objGenerateM3u8$default == obj) {
                        return obj;
                    }
                    embedUrl4 = embedUrl3;
                    function13 = function10;
                    function14 = function11;
                    url4 = url2;
                    scriptData2 = scriptData;
                    pageResponse2 = pageResponse;
                    iframeElement4 = iframeElement2;
                    headers3 = headers2;
                    referer7 = $result;
                    Iterable $this$forEach$iv8 = (Iterable) objGenerateM3u8$default;
                    $i$f$forEach = 0;
                    while (r1.hasNext()) {
                        int $i$f$forEach5 = $i$f$forEach;
                        function13.invoke(element$iv2);
                        $i$f$forEach = $i$f$forEach5;
                    }
                } else {
                    Log.INSTANCE.d("Filesim", "No m3u8 found via script or WebView fallback.");
                }
                return Unit.INSTANCE;
            case 5:
                String m3u8Url7 = (String) c03102.L$9;
                scriptData2 = (String) c03102.L$8;
                headers3 = (Map) c03102.L$7;
                iframeElement4 = (Element) c03102.L$6;
                pageResponse2 = (NiceResponse) c03102.L$5;
                embedUrl4 = (String) c03102.L$4;
                function13 = (Function1) c03102.L$3;
                function14 = (Function1) c03102.L$2;
                referer7 = (String) c03102.L$1;
                url4 = (String) c03102.L$0;
                ResultKt.throwOnFailure($result2);
                m3u8Url2 = m3u8Url7;
                objGenerateM3u8$default = $result2;
                Iterable $this$forEach$iv9 = (Iterable) objGenerateM3u8$default;
                $i$f$forEach = 0;
                while (r1.hasNext()) {
                    int $i$f$forEach6 = $i$f$forEach;
                    function13.invoke(element$iv2);
                    $i$f$forEach = $i$f$forEach6;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
