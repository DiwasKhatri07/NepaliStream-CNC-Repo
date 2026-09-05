package com.Anichi;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.network.WebViewResolver;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.JsUnpacker;
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
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: AnichiExtractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/Anichi/FilemoonV2;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnichiExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/FilemoonV2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,984:1\n2068#2,2:985\n2068#2,2:987\n*S KotlinDebug\n*F\n+ 1 AnichiExtractors.kt\ncom/Anichi/FilemoonV2\n*L\n435#1:985,2\n456#1:987,2\n*E\n"})
public final class FilemoonV2 extends ExtractorApi {

    @NotNull
    private String name = "Filemoon";

    @NotNull
    private String mainUrl = "https://filemoon.to";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Anichi.FilemoonV2$getUrl$1 */
    /* JADX INFO: compiled from: AnichiExtractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.FilemoonV2", f = "AnichiExtractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {419, 420, 430, 444, 451}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "headers", "url", "referer", "subtitleCallback", "callback", "headers", "href", "url", "referer", "subtitleCallback", "callback", "headers", "href", "scriptContent", "m3u8", "url", "referer", "subtitleCallback", "callback", "headers", "href", "scriptContent", "m3u8", "resolver", "url", "referer", "subtitleCallback", "callback", "headers", "href", "scriptContent", "m3u8", "resolver", "m3u82"}, nl = {423, 423, 435, 448, 456}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00341 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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

        C00341(Continuation<? super C00341> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FilemoonV2.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x01df  */
    /* JADX WARN: Code duplicated, block: B:28:0x0248 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0249  */
    /* JADX WARN: Code duplicated, block: B:32:0x025d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0262  */
    /* JADX WARN: Code duplicated, block: B:36:0x0273  */
    /* JADX WARN: Code duplicated, block: B:42:0x0296 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:45:0x029b  */
    /* JADX WARN: Code duplicated, block: B:47:0x02e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:52:0x0300 A[LOOP:1: B:50:0x02fa->B:52:0x0300, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x030b  */
    /* JADX WARN: Code duplicated, block: B:56:0x03a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:61:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:63:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x0412 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0413  */
    /* JADX WARN: Code duplicated, block: B:70:0x042e A[LOOP:0: B:68:0x0428->B:70:0x042e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x043f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00341 c00341;
        char c;
        Object obj;
        String str;
        int i;
        String url2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Map headers;
        Object obj2;
        String referer2;
        Element elementSelectFirst;
        String href;
        Map headers2;
        String referer3;
        String href2;
        Function1<? super ExtractorLink, Unit> function5;
        Object obj3;
        Function1<? super ExtractorLink, Unit> function6;
        Map headers3;
        String href3;
        Element elementSelectFirst2;
        String strData;
        String scriptContent;
        String unpacked;
        String m3u8;
        String m3u9;
        Map headers4;
        WebViewResolver resolver;
        Function1<? super ExtractorLink, Unit> function7;
        String scriptContent2;
        String $result;
        String referer4;
        Object obj4;
        String href4;
        String referer5;
        Function1<? super ExtractorLink, Unit> function8;
        Map headers5;
        Object objGenerateM3u8$default;
        Function1<? super ExtractorLink, Unit> function9;
        MatchResult matchResultFind$default;
        List groupValues;
        String m3u82;
        boolean z;
        Object objGenerateM3u8$default2;
        String scriptContent3;
        String href5;
        Function1<? super ExtractorLink, Unit> function10;
        String referer6;
        String m3u83;
        String href6;
        Function1<? super SubtitleFile, Unit> function11;
        if (continuation instanceof C00341) {
            c00341 = (C00341) continuation;
            if ((c00341.label & Integer.MIN_VALUE) != 0) {
                c00341.label -= Integer.MIN_VALUE;
            } else {
                c00341 = new C00341(continuation);
            }
        } else {
            c00341 = new C00341(continuation);
        }
        C00341 c00342 = c00341;
        Object $result2 = c00342.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00342.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Map headers6 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Referer", url), TuplesKt.to("Sec-Fetch-Dest", "iframe"), TuplesKt.to("Sec-Fetch-Mode", "navigate"), TuplesKt.to("Sec-Fetch-Site", "cross-site"), TuplesKt.to("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:137.0) Gecko/20100101 Firefox/137.0")});
                Requests app = MainActivityKt.getApp();
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00342.L$1 = referer;
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00342.L$3 = function2;
                c00342.L$4 = headers6;
                c00342.label = 1;
                c = 0;
                obj = coroutine_suspended;
                str = "iframe";
                i = 2;
                Object obj5 = Requests.get$default(app, url, headers6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00342, 4092, (Object) null);
                c00342 = c00342;
                if (obj5 == obj) {
                    return obj;
                }
                url2 = url;
                function3 = function1;
                function4 = function2;
                headers = headers6;
                obj2 = obj5;
                referer2 = referer;
                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst(str);
                if (elementSelectFirst != null || (href = elementSelectFirst.attr("src")) == null) {
                    href = "";
                }
                Requests app2 = MainActivityKt.getApp();
                Pair[] pairArr = new Pair[i];
                pairArr[c] = TuplesKt.to("Accept-Language", "en-US,en;q=0.5");
                pairArr[1] = TuplesKt.to("sec-fetch-dest", str);
                Map mapMapOf = MapsKt.mapOf(pairArr);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00342.L$1 = referer2;
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00342.L$3 = function4;
                c00342.L$4 = headers;
                c00342.L$5 = href;
                c00342.label = i;
                headers2 = headers;
                C00341 c00343 = c00342;
                referer3 = referer2;
                href2 = href;
                function5 = function4;
                obj3 = Requests.get$default(app2, href2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00343, 4092, (Object) null);
                c00342 = c00343;
                if (obj3 == obj) {
                    return obj;
                }
                function6 = function5;
                headers3 = headers2;
                href3 = href2;
                elementSelectFirst2 = ((NiceResponse) obj3).getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                String str2 = null;
                if (elementSelectFirst2 != null) {
                    strData = elementSelectFirst2.data();
                } else {
                    strData = null;
                }
                scriptContent = String.valueOf(strData);
                unpacked = new JsUnpacker(scriptContent).unpack();
                if (unpacked == null && (matchResultFind$default = Regex.find$default(new Regex("sources:\\[\\{file:\"(.*?)\""), unpacked, 0, i, (Object) null)) != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    str2 = (String) groupValues.get(1);
                }
                m3u8 = str2;
                if (m3u8 != null) {
                    M3u8Helper.Companion companion = M3u8Helper.Companion;
                    String name = getName();
                    String mainUrl = getMainUrl();
                    c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00342.L$3 = function6;
                    c00342.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00342.L$5 = SpillingKt.nullOutSpilledVariable(href3);
                    c00342.L$6 = SpillingKt.nullOutSpilledVariable(scriptContent);
                    c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00342.label = 3;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, mainUrl, (Integer) null, headers3, (String) null, c00342, 40, (Object) null);
                    if (objGenerateM3u8$default == obj) {
                        return obj;
                    }
                    function9 = function6;
                    Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                    for (Object element$iv : $this$forEach$iv) {
                        function9.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                }
                m3u9 = m3u8;
                headers4 = headers3;
                resolver = new WebViewResolver(new Regex("(m3u8|master\\.txt)"), CollectionsKt.listOf(new Regex("(m3u8|master\\.txt)")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00342.L$3 = function6;
                c00342.L$4 = headers4;
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(href3);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(scriptContent);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(resolver);
                c00342.label = 4;
                C00341 c00344 = c00342;
                function7 = function6;
                scriptContent2 = href3;
                $result = scriptContent;
                referer4 = referer3;
                obj4 = Requests.get$default(MainActivityKt.getApp(), scriptContent2, (Map) null, referer4, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) resolver, false, (ResponseParser) null, c00344, 3578, (Object) null);
                c00342 = c00344;
                if (obj4 == obj) {
                    return obj;
                }
                href4 = scriptContent2;
                referer5 = referer4;
                function8 = function7;
                headers5 = headers4;
                m3u82 = ((NiceResponse) obj4).getUrl();
                if (m3u82.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                    String name2 = getName();
                    String mainUrl2 = getMainUrl();
                    c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00342.L$3 = function8;
                    c00342.L$4 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00342.L$5 = SpillingKt.nullOutSpilledVariable(href4);
                    c00342.L$6 = SpillingKt.nullOutSpilledVariable($result);
                    c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00342.L$8 = SpillingKt.nullOutSpilledVariable(resolver);
                    c00342.L$9 = SpillingKt.nullOutSpilledVariable(m3u82);
                    c00342.label = 5;
                    objGenerateM3u8$default2 = M3u8Helper.Companion.generateM3u8$default(companion2, name2, m3u82, mainUrl2, (Integer) null, headers5, (String) null, c00342, 40, (Object) null);
                    if (objGenerateM3u8$default2 == obj) {
                        return obj;
                    }
                    scriptContent3 = $result;
                    href5 = href4;
                    function10 = function8;
                    referer6 = referer5;
                    m3u83 = m3u9;
                    href6 = url2;
                    function11 = function3;
                    Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default2;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        function10.invoke(element$iv2);
                    }
                } else {
                    Log.INSTANCE.d("Error", "No m3u8 intercepted in fallback.");
                }
                return Unit.INSTANCE;
            case 1:
                Map headers7 = (Map) c00342.L$4;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00342.L$3;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c00342.L$2;
                String referer7 = (String) c00342.L$1;
                String url3 = (String) c00342.L$0;
                ResultKt.throwOnFailure($result2);
                obj2 = $result2;
                obj = coroutine_suspended;
                headers = headers7;
                str = "iframe";
                function4 = function12;
                function3 = function13;
                referer2 = referer7;
                url2 = url3;
                i = 2;
                c = 0;
                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst(str);
                if (elementSelectFirst != null) {
                    href = "";
                } else {
                    href = "";
                }
                Requests app3 = MainActivityKt.getApp();
                Pair[] pairArr2 = new Pair[i];
                pairArr2[c] = TuplesKt.to("Accept-Language", "en-US,en;q=0.5");
                pairArr2[1] = TuplesKt.to("sec-fetch-dest", str);
                Map mapMapOf2 = MapsKt.mapOf(pairArr2);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00342.L$1 = referer2;
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00342.L$3 = function4;
                c00342.L$4 = headers;
                c00342.L$5 = href;
                c00342.label = i;
                headers2 = headers;
                C00341 c00345 = c00342;
                referer3 = referer2;
                href2 = href;
                function5 = function4;
                obj3 = Requests.get$default(app3, href2, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00345, 4092, (Object) null);
                c00342 = c00345;
                if (obj3 == obj) {
                    return obj;
                }
                function6 = function5;
                headers3 = headers2;
                href3 = href2;
                elementSelectFirst2 = ((NiceResponse) obj3).getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                String str3 = null;
                if (elementSelectFirst2 != null) {
                    strData = elementSelectFirst2.data();
                } else {
                    strData = null;
                }
                scriptContent = String.valueOf(strData);
                unpacked = new JsUnpacker(scriptContent).unpack();
                if (unpacked == null) {
                }
                m3u8 = str3;
                if (m3u8 != null) {
                    M3u8Helper.Companion companion3 = M3u8Helper.Companion;
                    String name3 = getName();
                    String mainUrl3 = getMainUrl();
                    c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00342.L$3 = function6;
                    c00342.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00342.L$5 = SpillingKt.nullOutSpilledVariable(href3);
                    c00342.L$6 = SpillingKt.nullOutSpilledVariable(scriptContent);
                    c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00342.label = 3;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion3, name3, m3u8, mainUrl3, (Integer) null, headers3, (String) null, c00342, 40, (Object) null);
                    if (objGenerateM3u8$default == obj) {
                        return obj;
                    }
                    function9 = function6;
                    Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                    while (r1.hasNext()) {
                        function9.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                }
                m3u9 = m3u8;
                headers4 = headers3;
                resolver = new WebViewResolver(new Regex("(m3u8|master\\.txt)"), CollectionsKt.listOf(new Regex("(m3u8|master\\.txt)")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00342.L$3 = function6;
                c00342.L$4 = headers4;
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(href3);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(scriptContent);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(resolver);
                c00342.label = 4;
                C00341 c00346 = c00342;
                function7 = function6;
                scriptContent2 = href3;
                $result = scriptContent;
                referer4 = referer3;
                obj4 = Requests.get$default(MainActivityKt.getApp(), scriptContent2, (Map) null, referer4, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) resolver, false, (ResponseParser) null, c00346, 3578, (Object) null);
                c00342 = c00346;
                if (obj4 == obj) {
                    return obj;
                }
                href4 = scriptContent2;
                referer5 = referer4;
                function8 = function7;
                headers5 = headers4;
                m3u82 = ((NiceResponse) obj4).getUrl();
                if (m3u82.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    M3u8Helper.Companion companion4 = M3u8Helper.Companion;
                    String name4 = getName();
                    String mainUrl4 = getMainUrl();
                    c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00342.L$3 = function8;
                    c00342.L$4 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00342.L$5 = SpillingKt.nullOutSpilledVariable(href4);
                    c00342.L$6 = SpillingKt.nullOutSpilledVariable($result);
                    c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00342.L$8 = SpillingKt.nullOutSpilledVariable(resolver);
                    c00342.L$9 = SpillingKt.nullOutSpilledVariable(m3u82);
                    c00342.label = 5;
                    objGenerateM3u8$default2 = M3u8Helper.Companion.generateM3u8$default(companion4, name4, m3u82, mainUrl4, (Integer) null, headers5, (String) null, c00342, 40, (Object) null);
                    if (objGenerateM3u8$default2 == obj) {
                        return obj;
                    }
                    scriptContent3 = $result;
                    href5 = href4;
                    function10 = function8;
                    referer6 = referer5;
                    m3u83 = m3u9;
                    href6 = url2;
                    function11 = function3;
                    Iterable $this$forEach$iv4 = (Iterable) objGenerateM3u8$default2;
                    while (r1.hasNext()) {
                        function10.invoke(element$iv2);
                    }
                } else {
                    Log.INSTANCE.d("Error", "No m3u8 intercepted in fallback.");
                }
                return Unit.INSTANCE;
            case 2:
                String href7 = (String) c00342.L$5;
                headers3 = (Map) c00342.L$4;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00342.L$3;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c00342.L$2;
                String referer8 = (String) c00342.L$1;
                String url4 = (String) c00342.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                function3 = function15;
                referer3 = referer8;
                url2 = url4;
                i = 2;
                obj3 = $result2;
                function6 = function14;
                href3 = href7;
                elementSelectFirst2 = ((NiceResponse) obj3).getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                String str4 = null;
                if (elementSelectFirst2 != null) {
                    strData = elementSelectFirst2.data();
                } else {
                    strData = null;
                }
                scriptContent = String.valueOf(strData);
                unpacked = new JsUnpacker(scriptContent).unpack();
                if (unpacked == null) {
                }
                m3u8 = str4;
                if (m3u8 != null) {
                    M3u8Helper.Companion companion5 = M3u8Helper.Companion;
                    String name5 = getName();
                    String mainUrl5 = getMainUrl();
                    c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00342.L$3 = function6;
                    c00342.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00342.L$5 = SpillingKt.nullOutSpilledVariable(href3);
                    c00342.L$6 = SpillingKt.nullOutSpilledVariable(scriptContent);
                    c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00342.label = 3;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion5, name5, m3u8, mainUrl5, (Integer) null, headers3, (String) null, c00342, 40, (Object) null);
                    if (objGenerateM3u8$default == obj) {
                        return obj;
                    }
                    function9 = function6;
                    Iterable $this$forEach$iv5 = (Iterable) objGenerateM3u8$default;
                    while (r1.hasNext()) {
                        function9.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                }
                m3u9 = m3u8;
                headers4 = headers3;
                resolver = new WebViewResolver(new Regex("(m3u8|master\\.txt)"), CollectionsKt.listOf(new Regex("(m3u8|master\\.txt)")), (String) null, false, (String) null, (Function1) null, 15000L, 52, (DefaultConstructorMarker) null);
                c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00342.L$3 = function6;
                c00342.L$4 = headers4;
                c00342.L$5 = SpillingKt.nullOutSpilledVariable(href3);
                c00342.L$6 = SpillingKt.nullOutSpilledVariable(scriptContent);
                c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00342.L$8 = SpillingKt.nullOutSpilledVariable(resolver);
                c00342.label = 4;
                C00341 c00347 = c00342;
                function7 = function6;
                scriptContent2 = href3;
                $result = scriptContent;
                referer4 = referer3;
                obj4 = Requests.get$default(MainActivityKt.getApp(), scriptContent2, (Map) null, referer4, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) resolver, false, (ResponseParser) null, c00347, 3578, (Object) null);
                c00342 = c00347;
                if (obj4 == obj) {
                    return obj;
                }
                href4 = scriptContent2;
                referer5 = referer4;
                function8 = function7;
                headers5 = headers4;
                m3u82 = ((NiceResponse) obj4).getUrl();
                if (m3u82.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    M3u8Helper.Companion companion6 = M3u8Helper.Companion;
                    String name6 = getName();
                    String mainUrl6 = getMainUrl();
                    c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00342.L$3 = function8;
                    c00342.L$4 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00342.L$5 = SpillingKt.nullOutSpilledVariable(href4);
                    c00342.L$6 = SpillingKt.nullOutSpilledVariable($result);
                    c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00342.L$8 = SpillingKt.nullOutSpilledVariable(resolver);
                    c00342.L$9 = SpillingKt.nullOutSpilledVariable(m3u82);
                    c00342.label = 5;
                    objGenerateM3u8$default2 = M3u8Helper.Companion.generateM3u8$default(companion6, name6, m3u82, mainUrl6, (Integer) null, headers5, (String) null, c00342, 40, (Object) null);
                    if (objGenerateM3u8$default2 == obj) {
                        return obj;
                    }
                    scriptContent3 = $result;
                    href5 = href4;
                    function10 = function8;
                    referer6 = referer5;
                    m3u83 = m3u9;
                    href6 = url2;
                    function11 = function3;
                    Iterable $this$forEach$iv6 = (Iterable) objGenerateM3u8$default2;
                    while (r1.hasNext()) {
                        function10.invoke(element$iv2);
                    }
                } else {
                    Log.INSTANCE.d("Error", "No m3u8 intercepted in fallback.");
                }
                return Unit.INSTANCE;
            case 3:
                function9 = (Function1) c00342.L$3;
                ResultKt.throwOnFailure($result2);
                objGenerateM3u8$default = $result2;
                Iterable $this$forEach$iv7 = (Iterable) objGenerateM3u8$default;
                while (r1.hasNext()) {
                    function9.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 4:
                WebViewResolver resolver2 = (WebViewResolver) c00342.L$8;
                String m3u10 = (String) c00342.L$7;
                String scriptContent4 = (String) c00342.L$6;
                String href8 = (String) c00342.L$5;
                Map headers8 = (Map) c00342.L$4;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00342.L$3;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c00342.L$2;
                referer5 = (String) c00342.L$1;
                String url5 = (String) c00342.L$0;
                ResultKt.throwOnFailure($result2);
                obj4 = $result2;
                obj = coroutine_suspended;
                resolver = resolver2;
                m3u9 = m3u10;
                $result = scriptContent4;
                url2 = url5;
                function3 = function17;
                function8 = function16;
                href4 = href8;
                headers5 = headers8;
                m3u82 = ((NiceResponse) obj4).getUrl();
                if (m3u82.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    M3u8Helper.Companion companion7 = M3u8Helper.Companion;
                    String name7 = getName();
                    String mainUrl7 = getMainUrl();
                    c00342.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00342.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c00342.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00342.L$3 = function8;
                    c00342.L$4 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00342.L$5 = SpillingKt.nullOutSpilledVariable(href4);
                    c00342.L$6 = SpillingKt.nullOutSpilledVariable($result);
                    c00342.L$7 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00342.L$8 = SpillingKt.nullOutSpilledVariable(resolver);
                    c00342.L$9 = SpillingKt.nullOutSpilledVariable(m3u82);
                    c00342.label = 5;
                    objGenerateM3u8$default2 = M3u8Helper.Companion.generateM3u8$default(companion7, name7, m3u82, mainUrl7, (Integer) null, headers5, (String) null, c00342, 40, (Object) null);
                    if (objGenerateM3u8$default2 == obj) {
                        return obj;
                    }
                    scriptContent3 = $result;
                    href5 = href4;
                    function10 = function8;
                    referer6 = referer5;
                    m3u83 = m3u9;
                    href6 = url2;
                    function11 = function3;
                    Iterable $this$forEach$iv8 = (Iterable) objGenerateM3u8$default2;
                    while (r1.hasNext()) {
                        function10.invoke(element$iv2);
                    }
                } else {
                    Log.INSTANCE.d("Error", "No m3u8 intercepted in fallback.");
                }
                return Unit.INSTANCE;
            case 5:
                m3u83 = (String) c00342.L$7;
                scriptContent3 = (String) c00342.L$6;
                href5 = (String) c00342.L$5;
                headers5 = (Map) c00342.L$4;
                function10 = (Function1) c00342.L$3;
                function11 = (Function1) c00342.L$2;
                referer6 = (String) c00342.L$1;
                href6 = (String) c00342.L$0;
                ResultKt.throwOnFailure($result2);
                objGenerateM3u8$default2 = $result2;
                Iterable $this$forEach$iv9 = (Iterable) objGenerateM3u8$default2;
                while (r1.hasNext()) {
                    function10.invoke(element$iv2);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
