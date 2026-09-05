package com.ohli24;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OHLI24/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ohli24/Cdndania;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "OHLI24"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/ohli24/Cdndania\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n73#2,5:79\n1#3:84\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/ohli24/Cdndania\n*L\n39#1:79,5\n*E\n"})
public class Cdndania extends ExtractorApi {

    @NotNull
    private final String name = "CDNdania";

    @NotNull
    private final String mainUrl = "https://cdndania.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.ohli24.Cdndania$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ohli24.Cdndania", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {31, 39, 42, 55}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "host", "$this", "url", "referer", "subtitleCallback", "callback", "host", "doc", "srtRegex", "srtUrl", "extractedHash", "m3u8Url", "header", "formdata", "$this", "url", "referer", "subtitleCallback", "callback", "host", "doc", "srtRegex", "srtUrl", "extractedHash", "m3u8Url", "header", "formdata", "response", "m3u8", "$this", "url", "referer", "subtitleCallback", "callback", "host", "doc", "srtRegex", "srtUrl", "extractedHash", "m3u8Url", "header", "formdata", "response", "m3u8"}, nl = {31, 79, 41, 54}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Cdndania.getUrl$suspendImpl(Cdndania.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:24:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:25:0x0202  */
    /* JADX WARN: Code duplicated, block: B:28:0x0207  */
    /* JADX WARN: Code duplicated, block: B:39:0x0307 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0308  */
    /* JADX WARN: Code duplicated, block: B:48:0x033d  */
    /* JADX WARN: Code duplicated, block: B:56:0x043d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x043e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    static /* synthetic */ Object getUrl$suspendImpl(Cdndania $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00001 c00001;
        Object obj;
        int i;
        Cdndania $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        String host;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String strData;
        String srtUrl;
        String doc;
        Regex srtRegex;
        MatchResult matchResultFind$default;
        String m3u8Url;
        Map header;
        Map formdata;
        String srtUrl2;
        String host2;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        String url3;
        String extractedHash;
        Object objPost$default;
        Regex srtRegex2;
        String extractedHash2;
        Map formdata2;
        String doc2;
        Function1<? super SubtitleFile, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        String srtUrl3;
        String srtUrl4;
        Map header2;
        List groupValues;
        String str;
        Object safe;
        Response response;
        String m3u8;
        String srtUrl5;
        Regex srtRegex3;
        String doc3;
        Function1<? super ExtractorLink, Unit> function9;
        String doc4;
        Map header3;
        String m3u8Url2;
        Response response2;
        String m3u9;
        String url4;
        Function1<? super SubtitleFile, Unit> function10;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = $this.new C00001(continuation);
            }
        } else {
            c00001 = $this.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String host3 = $this.getBaseUrl(url);
                if (StringsKt.contains$default(url, "/video/", false, 2, (Object) null)) {
                    Requests app = MainActivityKt.getApp();
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable($this);
                    c00002.L$1 = url;
                    c00002.L$2 = referer;
                    c00002.L$3 = function1;
                    c00002.L$4 = function2;
                    c00002.L$5 = host3;
                    c00002.label = 1;
                    obj = coroutine_suspended;
                    i = 0;
                    Object obj3 = Requests.get$default(app, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4090, (Object) null);
                    if (obj3 == obj) {
                        c00002 = c00002;
                        return obj;
                    }
                    c00002 = c00002;
                    $this2 = $this;
                    url2 = url;
                    referer2 = referer;
                    function3 = function1;
                    obj2 = obj3;
                    host = host3;
                    function4 = function2;
                    elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("script:containsData(playerjsSubtitle)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                    srtUrl = "";
                    if (strData == null) {
                        strData = "";
                    }
                    doc = strData;
                    srtRegex = new Regex("playerjsSubtitle\\s*=\\s*\"[^\"]*(https?://[^\"]+\\.srt)\"");
                    matchResultFind$default = Regex.find$default(srtRegex, doc, i, 2, (Object) null);
                    if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = (String) groupValues.get(1)) != null) {
                        srtUrl = str;
                    }
                    String extractedHash3 = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                    m3u8Url = host + "/player/index.php?data=" + extractedHash3 + "&do=getVideo";
                    header = MapsKt.mapOf(TuplesKt.to("x-requested-with", "XMLHttpRequest"));
                    Pair[] pairArr = new Pair[2];
                    pairArr[i] = TuplesKt.to("hash", extractedHash3);
                    pairArr[1] = TuplesKt.to("r", String.valueOf(referer2));
                    formdata = MapsKt.mapOf(pairArr);
                    String url5 = url2;
                    Requests app2 = MainActivityKt.getApp();
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(url5);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00002.L$3 = function3;
                    c00002.L$4 = function4;
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(host);
                    c00002.L$6 = SpillingKt.nullOutSpilledVariable(doc);
                    c00002.L$7 = SpillingKt.nullOutSpilledVariable(srtRegex);
                    c00002.L$8 = srtUrl;
                    c00002.L$9 = SpillingKt.nullOutSpilledVariable(extractedHash3);
                    c00002.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Url);
                    c00002.L$11 = SpillingKt.nullOutSpilledVariable(header);
                    c00002.L$12 = SpillingKt.nullOutSpilledVariable(formdata);
                    c00002.label = 2;
                    C00001 c00003 = c00002;
                    srtUrl2 = srtUrl;
                    host2 = host;
                    function5 = function3;
                    function6 = function4;
                    url3 = url5;
                    extractedHash = extractedHash3;
                    objPost$default = Requests.post$default(app2, m3u8Url, header, (String) null, (Map) null, (Map) null, formdata, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 65500, (Object) null);
                    c00002 = c00003;
                    if (objPost$default == obj) {
                        return obj;
                    }
                    srtRegex2 = srtRegex;
                    extractedHash2 = m3u8Url;
                    formdata2 = formdata;
                    doc2 = doc;
                    function7 = function5;
                    function8 = function6;
                    srtUrl3 = host2;
                    srtUrl4 = srtUrl2;
                    header2 = header;
                    $result = objPost$default;
                    NiceResponse this_$iv = (NiceResponse) $result;
                    try {
                        ResponseParser parser = this_$iv.getParser();
                        Intrinsics.checkNotNull(parser);
                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                    } catch (Exception e$iv) {
                        e$iv.printStackTrace();
                        safe = null;
                    }
                    response = (Response) safe;
                    if (response == null && (m3u8 = response.getVideoSource()) != null) {
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        Cdndania$getUrl$2$1 cdndania$getUrl$2$1 = new Cdndania$getUrl$2$1(null);
                        c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                        c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00002.L$3 = function7;
                        c00002.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                        c00002.L$5 = SpillingKt.nullOutSpilledVariable(srtUrl3);
                        c00002.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                        c00002.L$7 = SpillingKt.nullOutSpilledVariable(srtRegex2);
                        c00002.L$8 = srtUrl4;
                        c00002.L$9 = SpillingKt.nullOutSpilledVariable(extractedHash);
                        c00002.L$10 = SpillingKt.nullOutSpilledVariable(extractedHash2);
                        c00002.L$11 = SpillingKt.nullOutSpilledVariable(header2);
                        c00002.L$12 = SpillingKt.nullOutSpilledVariable(formdata2);
                        c00002.L$13 = SpillingKt.nullOutSpilledVariable(response);
                        c00002.L$14 = SpillingKt.nullOutSpilledVariable(m3u8);
                        c00002.L$15 = function8;
                        c00002.label = 3;
                        C00001 c00004 = c00002;
                        Object objNewExtractorLink = ExtractorApiKt.newExtractorLink("CDN", "CDN", m3u8, extractorLinkType, cdndania$getUrl$2$1, c00004);
                        c00002 = c00004;
                        if (objNewExtractorLink == obj) {
                            return obj;
                        }
                        srtUrl5 = srtUrl4;
                        srtRegex3 = srtRegex2;
                        doc3 = doc2;
                        function9 = function8;
                        doc4 = extractedHash;
                        header3 = header2;
                        m3u8Url2 = extractedHash2;
                        response2 = response;
                        m3u9 = m3u8;
                        url4 = url3;
                        $result = objNewExtractorLink;
                        function9.invoke($result);
                        c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                        c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00002.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        c00002.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                        c00002.L$5 = SpillingKt.nullOutSpilledVariable(srtUrl3);
                        c00002.L$6 = SpillingKt.nullOutSpilledVariable(doc3);
                        c00002.L$7 = SpillingKt.nullOutSpilledVariable(srtRegex3);
                        c00002.L$8 = SpillingKt.nullOutSpilledVariable(srtUrl5);
                        c00002.L$9 = SpillingKt.nullOutSpilledVariable(doc4);
                        c00002.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                        c00002.L$11 = SpillingKt.nullOutSpilledVariable(header3);
                        c00002.L$12 = SpillingKt.nullOutSpilledVariable(formdata2);
                        c00002.L$13 = SpillingKt.nullOutSpilledVariable(response2);
                        c00002.L$14 = SpillingKt.nullOutSpilledVariable(m3u9);
                        c00002.L$15 = function7;
                        c00002.label = 4;
                        $result = MainAPIKt.newSubtitleFile$default("Korean", srtUrl5, (Function2) null, c00002, 4, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        function10 = function7;
                        function10.invoke($result);
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 1:
                String host4 = (String) c00002.L$5;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00002.L$4;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00002.L$3;
                String referer3 = (String) c00002.L$2;
                String url6 = (String) c00002.L$1;
                Cdndania $this3 = (Cdndania) c00002.L$0;
                ResultKt.throwOnFailure($result);
                host = host4;
                $this2 = $this3;
                url2 = url6;
                obj = coroutine_suspended;
                function3 = function12;
                referer2 = referer3;
                i = 0;
                obj2 = $result;
                function4 = function11;
                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("script:containsData(playerjsSubtitle)");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                srtUrl = "";
                if (strData == null) {
                    strData = "";
                }
                doc = strData;
                srtRegex = new Regex("playerjsSubtitle\\s*=\\s*\"[^\"]*(https?://[^\"]+\\.srt)\"");
                matchResultFind$default = Regex.find$default(srtRegex, doc, i, 2, (Object) null);
                if (matchResultFind$default != null) {
                    srtUrl = str;
                }
                String extractedHash4 = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                m3u8Url = host + "/player/index.php?data=" + extractedHash4 + "&do=getVideo";
                header = MapsKt.mapOf(TuplesKt.to("x-requested-with", "XMLHttpRequest"));
                Pair[] pairArr2 = new Pair[2];
                pairArr2[i] = TuplesKt.to("hash", extractedHash4);
                pairArr2[1] = TuplesKt.to("r", String.valueOf(referer2));
                formdata = MapsKt.mapOf(pairArr2);
                String url7 = url2;
                Requests app3 = MainActivityKt.getApp();
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url7);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = function3;
                c00002.L$4 = function4;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(host);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(doc);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(srtRegex);
                c00002.L$8 = srtUrl;
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(extractedHash4);
                c00002.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Url);
                c00002.L$11 = SpillingKt.nullOutSpilledVariable(header);
                c00002.L$12 = SpillingKt.nullOutSpilledVariable(formdata);
                c00002.label = 2;
                C00001 c00005 = c00002;
                srtUrl2 = srtUrl;
                host2 = host;
                function5 = function3;
                function6 = function4;
                url3 = url7;
                extractedHash = extractedHash4;
                objPost$default = Requests.post$default(app3, m3u8Url, header, (String) null, (Map) null, (Map) null, formdata, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00005, 65500, (Object) null);
                c00002 = c00005;
                if (objPost$default == obj) {
                    return obj;
                }
                srtRegex2 = srtRegex;
                extractedHash2 = m3u8Url;
                formdata2 = formdata;
                doc2 = doc;
                function7 = function5;
                function8 = function6;
                srtUrl3 = host2;
                srtUrl4 = srtUrl2;
                header2 = header;
                $result = objPost$default;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                response = (Response) safe;
                if (response == null) {
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                Map formdata3 = (Map) c00002.L$12;
                Map header4 = (Map) c00002.L$11;
                String m3u8Url3 = (String) c00002.L$10;
                String extractedHash5 = (String) c00002.L$9;
                srtUrl4 = (String) c00002.L$8;
                srtRegex2 = (Regex) c00002.L$7;
                doc2 = (String) c00002.L$6;
                srtUrl3 = (String) c00002.L$5;
                function8 = (Function1) c00002.L$4;
                function7 = (Function1) c00002.L$3;
                formdata2 = formdata3;
                String referer4 = (String) c00002.L$2;
                String url8 = (String) c00002.L$1;
                Cdndania $this4 = (Cdndania) c00002.L$0;
                ResultKt.throwOnFailure($result);
                referer2 = referer4;
                url3 = url8;
                $this2 = $this4;
                obj = coroutine_suspended;
                extractedHash = extractedHash5;
                extractedHash2 = m3u8Url3;
                header2 = header4;
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                response = (Response) safe;
                if (response == null) {
                    break;
                }
                return Unit.INSTANCE;
            case 3:
                function9 = (Function1) c00002.L$15;
                m3u9 = (String) c00002.L$14;
                response2 = (Response) c00002.L$13;
                Map formdata4 = (Map) c00002.L$12;
                header3 = (Map) c00002.L$11;
                m3u8Url2 = (String) c00002.L$10;
                doc4 = (String) c00002.L$9;
                String srtUrl6 = (String) c00002.L$8;
                Regex srtRegex4 = (Regex) c00002.L$7;
                String doc5 = (String) c00002.L$6;
                String host5 = (String) c00002.L$5;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00002.L$4;
                Function1<? super SubtitleFile, Unit> function14 = (Function1) c00002.L$3;
                String referer5 = (String) c00002.L$2;
                url4 = (String) c00002.L$1;
                Cdndania $this5 = (Cdndania) c00002.L$0;
                ResultKt.throwOnFailure($result);
                referer2 = referer5;
                $this2 = $this5;
                obj = coroutine_suspended;
                srtUrl5 = srtUrl6;
                doc3 = doc5;
                srtUrl3 = host5;
                formdata2 = formdata4;
                srtRegex3 = srtRegex4;
                function7 = function14;
                function8 = function13;
                function9.invoke($result);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(srtUrl3);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(doc3);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(srtRegex3);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(srtUrl5);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(doc4);
                c00002.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                c00002.L$11 = SpillingKt.nullOutSpilledVariable(header3);
                c00002.L$12 = SpillingKt.nullOutSpilledVariable(formdata2);
                c00002.L$13 = SpillingKt.nullOutSpilledVariable(response2);
                c00002.L$14 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00002.L$15 = function7;
                c00002.label = 4;
                $result = MainAPIKt.newSubtitleFile$default("Korean", srtUrl5, (Function2) null, c00002, 4, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                function10 = function7;
                function10.invoke($result);
                return Unit.INSTANCE;
            case 4:
                function10 = (Function1) c00002.L$15;
                ResultKt.throwOnFailure($result);
                function10.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String getBaseUrl(String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }
}
