package com.Anichi;

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
import java.util.Collection;
import java.util.Iterator;
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

/* JADX INFO: compiled from: AnichiExtractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/Anichi/StreamWishExtractor;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEmbedUrl", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnichiExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/StreamWishExtractor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,984:1\n1960#2,3:985\n296#2,2:988\n2068#2,2:990\n2068#2,2:992\n*S KotlinDebug\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/StreamWishExtractor\n*L\n341#1:985,3\n342#1:988,2\n359#1:990,2\n381#1:992,2\n*E\n"})
public class StreamWishExtractor extends ExtractorApi {

    @NotNull
    private final String name = "Streamwish";

    @NotNull
    private final String mainUrl = "https://streamwish.to";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Anichi.StreamWishExtractor$getUrl$1 */
    /* JADX INFO: compiled from: AnichiExtractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.StreamWishExtractor", f = "AnichiExtractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {337, 354, 369, 376}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "headers", "response", "script", "m3u8", "$this", "url", "referer", "subtitleCallback", "callback", "headers", "response", "script", "m3u8", "m3u8Resolver", "$this", "url", "referer", "subtitleCallback", "callback", "headers", "response", "script", "m3u8", "m3u8Resolver", "intercepted"}, nl = {339, 359, 373, 381}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00351 extends ContinuationImpl {
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

        C00351(Continuation<? super C00351> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamWishExtractor.getUrl$suspendImpl(StreamWishExtractor.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:103:0x02bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x02b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x026e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0219  */
    /* JADX WARN: Code duplicated, block: B:29:0x021d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0227  */
    /* JADX WARN: Code duplicated, block: B:35:0x0245  */
    /* JADX WARN: Code duplicated, block: B:38:0x024f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0270 A[LOOP:3: B:36:0x0249->B:41:0x0270, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x027d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0292  */
    /* JADX WARN: Code duplicated, block: B:50:0x02b1 A[LOOP:2: B:45:0x028c->B:50:0x02b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:55:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:56:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:58:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:59:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:62:0x02de  */
    /* JADX WARN: Code duplicated, block: B:67:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:69:0x0300  */
    /* JADX WARN: Code duplicated, block: B:71:0x0304  */
    /* JADX WARN: Code duplicated, block: B:73:0x0355 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x0356  */
    /* JADX WARN: Code duplicated, block: B:78:0x0371 A[LOOP:1: B:76:0x036b->B:78:0x0371, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x037c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0412 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:83:0x0413  */
    /* JADX WARN: Code duplicated, block: B:87:0x042b  */
    /* JADX WARN: Code duplicated, block: B:89:0x042f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0488 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x0489  */
    /* JADX WARN: Code duplicated, block: B:96:0x04a6 A[LOOP:0: B:94:0x04a0->B:96:0x04a6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x04b7  */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    static /* synthetic */ Object getUrl$suspendImpl(StreamWishExtractor $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00351 c00351;
        Object obj;
        int i;
        ?? r2;
        StreamWishExtractor $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Map headers;
        Function1<? super ExtractorLink, Unit> function4;
        NiceResponse response;
        String packed;
        boolean z;
        String m3u8;
        Iterable $this$any$iv;
        int $i$f$any;
        Iterator it;
        boolean z2;
        Element it2;
        Iterable $this$any$iv2;
        int $i$f$any2;
        Element elementSelectFirst;
        String strData;
        Iterable $this$firstOrNull$iv;
        int $i$f$firstOrNull;
        Iterator it3;
        Object element$iv;
        Element element;
        Element it4;
        Iterable $this$firstOrNull$iv2;
        int $i$f$firstOrNull2;
        String script;
        Function1<? super ExtractorLink, Unit> function5;
        String m3u9;
        WebViewResolver m3u8Resolver;
        String url3;
        Map headers2;
        String referer3;
        StreamWishExtractor $this3;
        boolean z3;
        Object obj3;
        Function1<? super ExtractorLink, Unit> function6;
        String url4;
        String referer4;
        Function1<? super SubtitleFile, Unit> function7;
        Map headers3;
        Function1<? super ExtractorLink, Unit> function8;
        Function1<? super ExtractorLink, Unit> function9;
        MatchResult matchResultFind$default;
        List groupValues;
        String intercepted;
        Function1<? super ExtractorLink, Unit> function10;
        Function1<? super SubtitleFile, Unit> function11;
        String referer5;
        String intercepted2;
        NiceResponse response2;
        String script2;
        String url5;
        if (continuation instanceof C00351) {
            c00351 = (C00351) continuation;
            if ((c00351.label & Integer.MIN_VALUE) != 0) {
                c00351.label -= Integer.MIN_VALUE;
            } else {
                c00351 = $this.new C00351(continuation);
            }
        } else {
            c00351 = $this.new C00351(continuation);
        }
        C00351 c00352 = c00351;
        Object $result = c00352.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00352.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map headers4 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "*/*"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Sec-Fetch-Dest", "empty"), TuplesKt.to("Sec-Fetch-Mode", "cors"), TuplesKt.to("Sec-Fetch-Site", "cross-site"), TuplesKt.to("Referer", $this.getMainUrl() + '/'), TuplesKt.to("Origin", $this.getMainUrl() + '/'), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36")});
                Requests app = MainActivityKt.getApp();
                String embedUrl = $this.getEmbedUrl(url);
                c00352.L$0 = $this;
                c00352.L$1 = url;
                c00352.L$2 = referer;
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00352.L$4 = function2;
                c00352.L$5 = headers4;
                c00352.label = 1;
                obj = coroutine_suspended;
                i = 2;
                r2 = 0;
                Object obj4 = Requests.get$default(app, embedUrl, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00352, 4090, (Object) null);
                c00352 = c00352;
                if (obj4 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj4;
                headers = headers4;
                function4 = function2;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null || packed.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                m3u8 = null;
                if (z) {
                    $this$any$iv = response.getDocument().select("script");
                    $i$f$any = 0;
                    if (($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        it = $this$any$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object element$iv2 = it.next();
                                it2 = (Element) element$iv2;
                                $this$any$iv2 = $this$any$iv;
                                $i$f$any2 = $i$f$any;
                                if (StringsKt.contains$default(it2.html(), "jwplayer(\"vplayer\").setup(", (boolean) r2, i, (Object) null)) {
                                    z2 = true;
                                } else {
                                    $this$any$iv = $this$any$iv2;
                                    $i$f$any = $i$f$any2;
                                }
                            } else {
                                z2 = false;
                            }
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        $this$firstOrNull$iv = response.getDocument().select("script");
                        $i$f$firstOrNull = 0;
                        it3 = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                element$iv = it3.next();
                                it4 = (Element) element$iv;
                                $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                $i$f$firstOrNull2 = $i$f$firstOrNull;
                                if (StringsKt.contains$default(it4.html(), "jwplayer(\"vplayer\").setup(", (boolean) r2, i, (Object) null)) {
                                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                    $i$f$firstOrNull = $i$f$firstOrNull2;
                                }
                            } else {
                                element$iv = null;
                            }
                        }
                        element = (Element) element$iv;
                        if (element != null) {
                            strData = element.html();
                        } else {
                            strData = null;
                        }
                    } else {
                        elementSelectFirst = response.getDocument().selectFirst("script:containsData(sources:)");
                        if (elementSelectFirst != null) {
                            strData = elementSelectFirst.data();
                        } else {
                            strData = null;
                        }
                    }
                } else {
                    strData = ExtractorApiKt.getAndUnpack(response.getText());
                }
                script = strData;
                if (script != null) {
                    matchResultFind$default = Regex.find$default(new Regex("file:\\s*\"(.*?m3u8.*?)\""), script, (int) r2, i, (Object) null);
                    if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                        m3u8 = (String) CollectionsKt.getOrNull(groupValues, 1);
                    }
                } else {
                    m3u8 = null;
                }
                if (m3u8 != null) {
                    M3u8Helper.Companion companion = M3u8Helper.Companion;
                    String name = $this2.getName();
                    String mainUrl = $this2.getMainUrl();
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    c00352.L$4 = function4;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                    c00352.L$6 = SpillingKt.nullOutSpilledVariable(response);
                    c00352.L$7 = SpillingKt.nullOutSpilledVariable(script);
                    c00352.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00352.label = i;
                    function8 = function4;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, mainUrl, (Integer) null, headers, (String) null, c00352, 40, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    function9 = function8;
                    Iterable $this$forEach$iv = (Iterable) $result;
                    for (Object element$iv3 : $this$forEach$iv) {
                        function9.invoke(element$iv3);
                    }
                    return Unit.INSTANCE;
                }
                function5 = function4;
                m3u9 = m3u8;
                m3u8Resolver = new WebViewResolver(new Regex("txt|m3u8"), CollectionsKt.listOf(new Regex("txt|m3u8")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                url3 = url2;
                c00352.L$0 = $this2;
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00352.L$4 = function5;
                c00352.L$5 = headers;
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response);
                c00352.L$7 = SpillingKt.nullOutSpilledVariable(script);
                c00352.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00352.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Resolver);
                c00352.label = 3;
                headers2 = headers;
                C00351 c00353 = c00352;
                referer3 = referer2;
                $this3 = $this2;
                z3 = true;
                obj3 = Requests.get$default(MainActivityKt.getApp(), url3, (Map) null, referer3, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) m3u8Resolver, false, (ResponseParser) null, c00353, 3578, (Object) null);
                c00352 = c00353;
                if (obj3 == obj) {
                    return obj;
                }
                function6 = function5;
                url4 = url3;
                referer4 = referer3;
                function7 = function3;
                headers3 = headers2;
                intercepted = ((NiceResponse) obj3).getUrl();
                if (intercepted.length() <= 0) {
                    z3 = false;
                }
                if (z3) {
                    M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                    String name2 = $this3.getName();
                    String mainUrl2 = $this3.getMainUrl();
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    c00352.L$4 = function6;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00352.L$6 = SpillingKt.nullOutSpilledVariable(response);
                    c00352.L$7 = SpillingKt.nullOutSpilledVariable(script);
                    c00352.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00352.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Resolver);
                    c00352.L$10 = SpillingKt.nullOutSpilledVariable(intercepted);
                    c00352.label = 4;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion2, name2, intercepted, mainUrl2, (Integer) null, headers3, (String) null, c00352, 40, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    function10 = function6;
                    function11 = function7;
                    referer5 = referer4;
                    intercepted2 = m3u9;
                    response2 = response;
                    script2 = script;
                    url5 = url4;
                    Iterable $this$forEach$iv2 = (Iterable) $result;
                    for (Object element$iv4 : $this$forEach$iv2) {
                        function10.invoke(element$iv4);
                    }
                } else {
                    Log.INSTANCE.d("Error:", "No m3u8 found in fallback either.");
                }
                return Unit.INSTANCE;
            case 1:
                Map headers5 = (Map) c00352.L$5;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00352.L$4;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c00352.L$3;
                String referer6 = (String) c00352.L$2;
                String url6 = (String) c00352.L$1;
                StreamWishExtractor $this4 = (StreamWishExtractor) c00352.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this4;
                obj = coroutine_suspended;
                headers = headers5;
                function4 = function12;
                function3 = function13;
                referer2 = referer6;
                url2 = url6;
                i = 2;
                obj2 = $result;
                r2 = 0;
                response = (NiceResponse) obj2;
                packed = ExtractorApiKt.getPacked(response.getText());
                if (packed != null) {
                    z = true;
                } else {
                    z = true;
                }
                m3u8 = null;
                if (z) {
                    strData = ExtractorApiKt.getAndUnpack(response.getText());
                } else {
                    $this$any$iv = response.getDocument().select("script");
                    $i$f$any = 0;
                    if ($this$any$iv instanceof Collection) {
                        it = $this$any$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object element$iv5 = it.next();
                                it2 = (Element) element$iv5;
                                $this$any$iv2 = $this$any$iv;
                                $i$f$any2 = $i$f$any;
                                if (StringsKt.contains$default(it2.html(), "jwplayer(\"vplayer\").setup(", (boolean) r2, i, (Object) null)) {
                                    z2 = true;
                                } else {
                                    $this$any$iv = $this$any$iv2;
                                    $i$f$any = $i$f$any2;
                                }
                            } else {
                                z2 = false;
                            }
                        }
                    } else {
                        it = $this$any$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object element$iv6 = it.next();
                                it2 = (Element) element$iv6;
                                $this$any$iv2 = $this$any$iv;
                                $i$f$any2 = $i$f$any;
                                if (StringsKt.contains$default(it2.html(), "jwplayer(\"vplayer\").setup(", (boolean) r2, i, (Object) null)) {
                                    z2 = true;
                                } else {
                                    $this$any$iv = $this$any$iv2;
                                    $i$f$any = $i$f$any2;
                                }
                            } else {
                                z2 = false;
                            }
                        }
                    }
                    if (z2) {
                        $this$firstOrNull$iv = response.getDocument().select("script");
                        $i$f$firstOrNull = 0;
                        it3 = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                element$iv = it3.next();
                                it4 = (Element) element$iv;
                                $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                $i$f$firstOrNull2 = $i$f$firstOrNull;
                                if (StringsKt.contains$default(it4.html(), "jwplayer(\"vplayer\").setup(", (boolean) r2, i, (Object) null)) {
                                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                    $i$f$firstOrNull = $i$f$firstOrNull2;
                                }
                            } else {
                                element$iv = null;
                            }
                        }
                        element = (Element) element$iv;
                        if (element != null) {
                            strData = element.html();
                        } else {
                            strData = null;
                        }
                    } else {
                        elementSelectFirst = response.getDocument().selectFirst("script:containsData(sources:)");
                        if (elementSelectFirst != null) {
                            strData = elementSelectFirst.data();
                        } else {
                            strData = null;
                        }
                    }
                }
                script = strData;
                if (script != null) {
                    matchResultFind$default = Regex.find$default(new Regex("file:\\s*\"(.*?m3u8.*?)\""), script, (int) r2, i, (Object) null);
                    if (matchResultFind$default == null) {
                    }
                } else {
                    m3u8 = null;
                }
                if (m3u8 != null) {
                    M3u8Helper.Companion companion3 = M3u8Helper.Companion;
                    String name3 = $this2.getName();
                    String mainUrl3 = $this2.getMainUrl();
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    c00352.L$4 = function4;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                    c00352.L$6 = SpillingKt.nullOutSpilledVariable(response);
                    c00352.L$7 = SpillingKt.nullOutSpilledVariable(script);
                    c00352.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00352.label = i;
                    function8 = function4;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion3, name3, m3u8, mainUrl3, (Integer) null, headers, (String) null, c00352, 40, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    function9 = function8;
                    Iterable $this$forEach$iv3 = (Iterable) $result;
                    while (r12.hasNext()) {
                        function9.invoke(element$iv3);
                    }
                    return Unit.INSTANCE;
                }
                function5 = function4;
                m3u9 = m3u8;
                m3u8Resolver = new WebViewResolver(new Regex("txt|m3u8"), CollectionsKt.listOf(new Regex("txt|m3u8")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                url3 = url2;
                c00352.L$0 = $this2;
                c00352.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00352.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00352.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00352.L$4 = function5;
                c00352.L$5 = headers;
                c00352.L$6 = SpillingKt.nullOutSpilledVariable(response);
                c00352.L$7 = SpillingKt.nullOutSpilledVariable(script);
                c00352.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00352.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Resolver);
                c00352.label = 3;
                headers2 = headers;
                C00351 c00354 = c00352;
                referer3 = referer2;
                $this3 = $this2;
                z3 = true;
                obj3 = Requests.get$default(MainActivityKt.getApp(), url3, (Map) null, referer3, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) m3u8Resolver, false, (ResponseParser) null, c00354, 3578, (Object) null);
                c00352 = c00354;
                if (obj3 == obj) {
                    return obj;
                }
                function6 = function5;
                url4 = url3;
                referer4 = referer3;
                function7 = function3;
                headers3 = headers2;
                intercepted = ((NiceResponse) obj3).getUrl();
                if (intercepted.length() <= 0) {
                    z3 = false;
                }
                if (z3) {
                    M3u8Helper.Companion companion4 = M3u8Helper.Companion;
                    String name4 = $this3.getName();
                    String mainUrl4 = $this3.getMainUrl();
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    c00352.L$4 = function6;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00352.L$6 = SpillingKt.nullOutSpilledVariable(response);
                    c00352.L$7 = SpillingKt.nullOutSpilledVariable(script);
                    c00352.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00352.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Resolver);
                    c00352.L$10 = SpillingKt.nullOutSpilledVariable(intercepted);
                    c00352.label = 4;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion4, name4, intercepted, mainUrl4, (Integer) null, headers3, (String) null, c00352, 40, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    function10 = function6;
                    function11 = function7;
                    referer5 = referer4;
                    intercepted2 = m3u9;
                    response2 = response;
                    script2 = script;
                    url5 = url4;
                    Iterable $this$forEach$iv4 = (Iterable) $result;
                    while (r14.hasNext()) {
                        function10.invoke(element$iv4);
                    }
                } else {
                    Log.INSTANCE.d("Error:", "No m3u8 found in fallback either.");
                }
                return Unit.INSTANCE;
            case 2:
                function9 = (Function1) c00352.L$4;
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv5 = (Iterable) $result;
                while (r12.hasNext()) {
                    function9.invoke(element$iv3);
                }
                return Unit.INSTANCE;
            case 3:
                WebViewResolver m3u8Resolver2 = (WebViewResolver) c00352.L$9;
                String m3u10 = (String) c00352.L$8;
                String script3 = (String) c00352.L$7;
                NiceResponse response3 = (NiceResponse) c00352.L$6;
                Map headers6 = (Map) c00352.L$5;
                function6 = (Function1) c00352.L$4;
                function7 = (Function1) c00352.L$3;
                referer4 = (String) c00352.L$2;
                String url7 = (String) c00352.L$1;
                StreamWishExtractor $this5 = (StreamWishExtractor) c00352.L$0;
                ResultKt.throwOnFailure($result);
                $this3 = $this5;
                obj = coroutine_suspended;
                m3u8Resolver = m3u8Resolver2;
                url4 = url7;
                m3u9 = m3u10;
                script = script3;
                response = response3;
                headers3 = headers6;
                z3 = true;
                obj3 = $result;
                intercepted = ((NiceResponse) obj3).getUrl();
                if (intercepted.length() <= 0) {
                    z3 = false;
                }
                if (z3) {
                    M3u8Helper.Companion companion5 = M3u8Helper.Companion;
                    String name5 = $this3.getName();
                    String mainUrl5 = $this3.getMainUrl();
                    c00352.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    c00352.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00352.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                    c00352.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    c00352.L$4 = function6;
                    c00352.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00352.L$6 = SpillingKt.nullOutSpilledVariable(response);
                    c00352.L$7 = SpillingKt.nullOutSpilledVariable(script);
                    c00352.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00352.L$9 = SpillingKt.nullOutSpilledVariable(m3u8Resolver);
                    c00352.L$10 = SpillingKt.nullOutSpilledVariable(intercepted);
                    c00352.label = 4;
                    $result = M3u8Helper.Companion.generateM3u8$default(companion5, name5, intercepted, mainUrl5, (Integer) null, headers3, (String) null, c00352, 40, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    function10 = function6;
                    function11 = function7;
                    referer5 = referer4;
                    intercepted2 = m3u9;
                    response2 = response;
                    script2 = script;
                    url5 = url4;
                    Iterable $this$forEach$iv6 = (Iterable) $result;
                    while (r14.hasNext()) {
                        function10.invoke(element$iv4);
                    }
                } else {
                    Log.INSTANCE.d("Error:", "No m3u8 found in fallback either.");
                }
                return Unit.INSTANCE;
            case 4:
                intercepted2 = (String) c00352.L$8;
                script2 = (String) c00352.L$7;
                response2 = (NiceResponse) c00352.L$6;
                headers3 = (Map) c00352.L$5;
                function10 = (Function1) c00352.L$4;
                function11 = (Function1) c00352.L$3;
                referer5 = (String) c00352.L$2;
                url5 = (String) c00352.L$1;
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv7 = (Iterable) $result;
                while (r14.hasNext()) {
                    function10.invoke(element$iv4);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String getEmbedUrl(String url) {
        if (StringsKt.contains$default(url, "/f/", false, 2, (Object) null)) {
            String videoId = StringsKt.substringAfter$default(url, "/f/", (String) null, 2, (Object) null);
            return getMainUrl() + '/' + videoId;
        }
        return url;
    }
}
