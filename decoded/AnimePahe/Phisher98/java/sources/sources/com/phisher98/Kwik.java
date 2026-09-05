package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import io.ktor.http.CodecsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Kwik;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/phisher98/Kwik\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1739#2:285\n1814#2,3:286\n296#2,2:289\n1#3:291\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/phisher98/Kwik\n*L\n74#1:285\n74#1:286,3\n74#1:289,2\n*E\n"})
public final class Kwik extends ExtractorApi {

    @NotNull
    private final String name = "Kwik";

    @NotNull
    private final String mainUrl = "https://kwik.cx";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Kwik$getUrl$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Kwik", f = "Utils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {68, 92, 111}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "$this$getUrl_u24lambda_u240", "url", "referer", "subtitleCallback", "callback", "res", "html", "title", "script", "unpacked", "m3u8", "fileName", "url", "referer", "subtitleCallback", "callback", "res", "html", "title", "script", "unpacked", "m3u8", "fileName", "mp4Url"}, nl = {67, 91, 110}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kwik.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:102:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:104:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:105:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:110:0x02db  */
    /* JADX WARN: Code duplicated, block: B:112:0x02de  */
    /* JADX WARN: Code duplicated, block: B:114:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:116:0x0355 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:117:0x0356  */
    /* JADX WARN: Code duplicated, block: B:120:0x037c  */
    /* JADX WARN: Code duplicated, block: B:122:0x043c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:123:0x043d  */
    /* JADX WARN: Code duplicated, block: B:125:0x045d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0231 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0204 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0160  */
    /* JADX WARN: Code duplicated, block: B:39:0x0165  */
    /* JADX WARN: Code duplicated, block: B:41:0x0168  */
    /* JADX WARN: Code duplicated, block: B:44:0x019c A[LOOP:0: B:42:0x0196->B:44:0x019c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:54:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:57:0x01fb A[LOOP:1: B:46:0x01bc->B:57:0x01fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x020d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0219  */
    /* JADX WARN: Code duplicated, block: B:64:0x021e  */
    /* JADX WARN: Code duplicated, block: B:71:0x022e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0251  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0256  */
    /* JADX WARN: Code duplicated, block: B:90:0x0281  */
    /* JADX WARN: Code duplicated, block: B:92:0x0294  */
    /* JADX WARN: Code duplicated, block: B:95:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:97:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:99:0x02b8  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00131 c00131;
        Function1<? super ExtractorLink, Unit> function3;
        Function1<? super SubtitleFile, Unit> function4;
        Function1<? super ExtractorLink, Unit> function5;
        String referer2;
        Object obj;
        Object obj2;
        String url2;
        Function1<? super ExtractorLink, Unit> function6;
        Function1<? super SubtitleFile, Unit> function7;
        String referer3;
        NiceResponse res;
        String html;
        String title;
        Collection destination$iv$iv;
        Iterable $this$firstOrNull$iv;
        int $i$f$firstOrNull;
        Iterator it;
        Object obj3;
        String strData;
        String script;
        String str;
        boolean z;
        Object obj4;
        String unpacked;
        MatchResult matchResultFind$default;
        MatchResult matchResultFind$default2;
        String str2;
        boolean z2;
        String m3u8;
        MatchResult matchResultFind$default3;
        List groupValues;
        List groupValues2;
        String unpacked2;
        String fileName;
        Object objNewExtractorLink;
        String m3u9;
        Function1<? super SubtitleFile, Unit> function8;
        NiceResponse res2;
        String html2;
        String html3;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super ExtractorLink, Unit> function10;
        String html4;
        String title2;
        String unpacked3;
        List groupValues3;
        String str3;
        Element elementSelectFirst;
        Object element$iv;
        String it2;
        Iterable $this$firstOrNull$iv2;
        int $i$f$firstOrNull2;
        Iterator it3;
        boolean z3;
        String m3u10;
        String unpacked4;
        Object objNewExtractorLink2;
        String unpacked5;
        Object obj5;
        String script2;
        Function1<? super ExtractorLink, Unit> function11;
        Function1<? super ExtractorLink, Unit> function12;
        String title3;
        String mp4Url;
        String fileName2;
        NiceResponse res3;
        Function1<? super SubtitleFile, Unit> function13;
        String url3 = url;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        C00131 c00132 = c00131;
        Object $result = c00132.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00132.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    Kwik $this$getUrl_u24lambda_u240 = this;
                    AnimePahe.Companion companion2 = AnimePahe.INSTANCE;
                    Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("referer", AnimePaheProviderPlugin.INSTANCE.getCurrentAnimepaheServer() + '/'));
                    c00132.L$0 = url3;
                    c00132.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                    c00132.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                    function3 = function2;
                    try {
                        c00132.L$3 = function3;
                        c00132.L$4 = SpillingKt.nullOutSpilledVariable($this$getUrl_u24lambda_u240);
                        c00132.label = 1;
                        Object objAppGet = companion2.appGet(url3, mapMapOf, c00132);
                        if (objAppGet == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function4 = function1;
                        obj = objAppGet;
                        function5 = function3;
                        referer2 = referer;
                        obj2 = Result.constructor-impl((NiceResponse) obj);
                        url2 = url3;
                        function6 = function5;
                        function7 = function4;
                        referer3 = referer2;
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        res = (NiceResponse) obj2;
                        if (res == null) {
                            return Unit.INSTANCE;
                        }
                        html = res.getText();
                        title = res.getDocument().title();
                        Iterable $this$map$iv = res.getDocument().select("script");
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            destination$iv$iv.add(((Element) item$iv$iv).data());
                        }
                        $this$firstOrNull$iv = (List) destination$iv$iv;
                        $i$f$firstOrNull = 0;
                        it = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (String) element$iv;
                                $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                $i$f$firstOrNull2 = $i$f$firstOrNull;
                                it3 = it;
                                if (!StringsKt.contains$default(it2, "function(p,a,c,k,e,", false, 2, (Object) null) || StringsKt.contains$default(it2, "eval(function", false, 2, (Object) null)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    obj3 = element$iv;
                                } else {
                                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                    $i$f$firstOrNull = $i$f$firstOrNull2;
                                    it = it3;
                                }
                            } else {
                                obj3 = null;
                            }
                        }
                        strData = (String) obj3;
                        if (strData == null) {
                            elementSelectFirst = res.getDocument().selectFirst("script:containsData(eval)");
                            if (elementSelectFirst != null) {
                                strData = elementSelectFirst.data();
                            } else {
                                strData = null;
                            }
                        }
                        script = strData;
                        str = script;
                        if (str != null || str.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                Kwik kwik = this;
                                obj4 = Result.constructor-impl(ExtractorApiKt.getAndUnpack(script));
                            } catch (Throwable th) {
                                Result.Companion companion4 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = html;
                            }
                            unpacked = (String) obj4;
                            break;
                        } else {
                            unpacked = html;
                        }
                        matchResultFind$default = Regex.find$default(new Regex("source\\s*=\\s*['\"]([^'\"]+)['\"]"), unpacked, 0, 2, (Object) null);
                        if (matchResultFind$default != null || (groupValues3 = matchResultFind$default.getGroupValues()) == null || (str3 = (String) CollectionsKt.getOrNull(groupValues3, 1)) == null) {
                            matchResultFind$default2 = Regex.find$default(new Regex("(https?://[^\\s'\"<>]+\\.m3u8[^\\s'\"<>]*)"), unpacked, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null) {
                                str2 = null;
                            } else {
                                str2 = (String) CollectionsKt.getOrNull(groupValues2, 1);
                            }
                            if (str2 == null) {
                                matchResultFind$default3 = Regex.find$default(new Regex("(https?://[^\\s'\"<>]+\\.(?:mp4|m3u8)[^\\s'\"<>]*)"), unpacked, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null || (groupValues = matchResultFind$default3.getGroupValues()) == null) {
                                    z2 = true;
                                    str2 = null;
                                } else {
                                    z2 = true;
                                    str2 = (String) CollectionsKt.getOrNull(groupValues, 1);
                                }
                                if (str2 == null) {
                                    m3u8 = "";
                                }
                            } else {
                                z2 = true;
                            }
                            m3u8 = str2;
                        } else {
                            m3u8 = str3;
                            z2 = true;
                        }
                        if (m3u8.length() != 0) {
                            z2 = false;
                        }
                        if (z2) {
                            return Unit.INSTANCE;
                        }
                        StringBuilder sb = new StringBuilder();
                        unpacked2 = unpacked;
                        String unpacked6 = StringsKt.substringBeforeLast$default(title, ".mp4", (String) null, 2, (Object) null);
                        fileName = sb.append(unpacked6).append(".mp4").toString();
                        String name = getName();
                        String title4 = getName();
                        ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                        C00142 c00142 = new C00142(title, null);
                        c00132.L$0 = url2;
                        c00132.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00132.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                        c00132.L$3 = function6;
                        c00132.L$4 = SpillingKt.nullOutSpilledVariable(res);
                        c00132.L$5 = SpillingKt.nullOutSpilledVariable(html);
                        c00132.L$6 = SpillingKt.nullOutSpilledVariable(title);
                        c00132.L$7 = SpillingKt.nullOutSpilledVariable(script);
                        c00132.L$8 = SpillingKt.nullOutSpilledVariable(unpacked2);
                        c00132.L$9 = m3u8;
                        c00132.L$10 = fileName;
                        c00132.L$11 = function6;
                        c00132.label = 2;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, title4, m3u8, infer_type, c00142, c00132);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        m3u9 = m3u8;
                        function8 = function7;
                        res2 = res;
                        html2 = html;
                        html3 = fileName;
                        function9 = function6;
                        function10 = function9;
                        html4 = title;
                        title2 = script;
                        unpacked3 = unpacked2;
                        function9.invoke(objNewExtractorLink);
                        if (StringsKt.contains$default(m3u9, "/stream/", false, 2, (Object) null)) {
                            m3u10 = m3u9;
                            String fileName3 = html3;
                            String mp4Url2 = StringsKt.substringBeforeLast$default(StringsKt.replace$default(m3u9, "/stream/", "/mp4/", false, 4, (Object) null), "/", (String) null, 2, (Object) null) + "?file=" + CodecsKt.encodeURLQueryComponent$default(html3, false, false, (Charset) null, 7, (Object) null);
                            String name2 = getName();
                            String str4 = getName() + " [Download]";
                            ExtractorLinkType extractorLinkType = ExtractorLinkType.VIDEO;
                            unpacked4 = unpacked3;
                            C00153 c00153 = new C00153(url2, fileName3, this, null);
                            c00132.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00132.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                            c00132.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00132.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                            c00132.L$4 = SpillingKt.nullOutSpilledVariable(res2);
                            c00132.L$5 = SpillingKt.nullOutSpilledVariable(html2);
                            c00132.L$6 = SpillingKt.nullOutSpilledVariable(html4);
                            c00132.L$7 = SpillingKt.nullOutSpilledVariable(title2);
                            c00132.L$8 = SpillingKt.nullOutSpilledVariable(unpacked4);
                            c00132.L$9 = SpillingKt.nullOutSpilledVariable(m3u10);
                            c00132.L$10 = SpillingKt.nullOutSpilledVariable(fileName3);
                            c00132.L$11 = SpillingKt.nullOutSpilledVariable(mp4Url2);
                            c00132.L$12 = function10;
                            c00132.label = 3;
                            objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name2, str4, mp4Url2, extractorLinkType, c00153, c00132);
                            if (objNewExtractorLink2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            unpacked5 = unpacked4;
                            obj5 = objNewExtractorLink2;
                            script2 = title2;
                            function11 = function10;
                            function12 = function11;
                            title3 = html4;
                            mp4Url = m3u10;
                            fileName2 = html3;
                            res3 = res2;
                            function13 = function8;
                            function11.invoke(obj5);
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        function4 = function1;
                        function5 = function3;
                        referer2 = referer;
                        Result.Companion companion5 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    function3 = function2;
                }
                break;
            case 1:
                function5 = (Function1) c00132.L$3;
                function4 = (Function1) c00132.L$2;
                referer2 = (String) c00132.L$1;
                url3 = (String) c00132.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    obj2 = Result.constructor-impl((NiceResponse) obj);
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion6 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                url2 = url3;
                function6 = function5;
                function7 = function4;
                referer3 = referer2;
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                res = (NiceResponse) obj2;
                if (res == null) {
                    return Unit.INSTANCE;
                }
                html = res.getText();
                title = res.getDocument().title();
                Iterable $this$map$iv2 = res.getDocument().select("script");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r20.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).data());
                }
                $this$firstOrNull$iv = (List) destination$iv$iv;
                $i$f$firstOrNull = 0;
                it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        it2 = (String) element$iv;
                        $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                        $i$f$firstOrNull2 = $i$f$firstOrNull;
                        it3 = it;
                        if (StringsKt.contains$default(it2, "function(p,a,c,k,e,", false, 2, (Object) null)) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            obj3 = element$iv;
                        } else {
                            $this$firstOrNull$iv = $this$firstOrNull$iv2;
                            $i$f$firstOrNull = $i$f$firstOrNull2;
                            it = it3;
                        }
                    } else {
                        obj3 = null;
                    }
                }
                strData = (String) obj3;
                if (strData == null) {
                    elementSelectFirst = res.getDocument().selectFirst("script:containsData(eval)");
                    if (elementSelectFirst != null) {
                        strData = elementSelectFirst.data();
                    } else {
                        strData = null;
                    }
                }
                script = strData;
                str = script;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (!z) {
                    Result.Companion companion7 = Result.Companion;
                    Kwik kwik2 = this;
                    obj4 = Result.constructor-impl(ExtractorApiKt.getAndUnpack(script));
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = html;
                    }
                    unpacked = (String) obj4;
                } else {
                    unpacked = html;
                }
                matchResultFind$default = Regex.find$default(new Regex("source\\s*=\\s*['\"]([^'\"]+)['\"]"), unpacked, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    matchResultFind$default2 = Regex.find$default(new Regex("(https?://[^\\s'\"<>]+\\.m3u8[^\\s'\"<>]*)"), unpacked, 0, 2, (Object) null);
                    if (matchResultFind$default2 != null) {
                        str2 = null;
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        matchResultFind$default3 = Regex.find$default(new Regex("(https?://[^\\s'\"<>]+\\.(?:mp4|m3u8)[^\\s'\"<>]*)"), unpacked, 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            z2 = true;
                            str2 = null;
                        } else {
                            z2 = true;
                            str2 = null;
                        }
                        if (str2 == null) {
                            m3u8 = "";
                        }
                    } else {
                        z2 = true;
                    }
                    m3u8 = str2;
                } else {
                    matchResultFind$default2 = Regex.find$default(new Regex("(https?://[^\\s'\"<>]+\\.m3u8[^\\s'\"<>]*)"), unpacked, 0, 2, (Object) null);
                    if (matchResultFind$default2 != null) {
                        str2 = null;
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        matchResultFind$default3 = Regex.find$default(new Regex("(https?://[^\\s'\"<>]+\\.(?:mp4|m3u8)[^\\s'\"<>]*)"), unpacked, 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            z2 = true;
                            str2 = null;
                        } else {
                            z2 = true;
                            str2 = null;
                        }
                        if (str2 == null) {
                            m3u8 = "";
                        }
                    } else {
                        z2 = true;
                    }
                    m3u8 = str2;
                }
                if (m3u8.length() != 0) {
                    z2 = false;
                }
                if (z2) {
                    return Unit.INSTANCE;
                }
                StringBuilder sb2 = new StringBuilder();
                unpacked2 = unpacked;
                String unpacked7 = StringsKt.substringBeforeLast$default(title, ".mp4", (String) null, 2, (Object) null);
                fileName = sb2.append(unpacked7).append(".mp4").toString();
                String name3 = getName();
                String title5 = getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00142 c00143 = new C00142(title, null);
                c00132.L$0 = url2;
                c00132.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00132.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00132.L$3 = function6;
                c00132.L$4 = SpillingKt.nullOutSpilledVariable(res);
                c00132.L$5 = SpillingKt.nullOutSpilledVariable(html);
                c00132.L$6 = SpillingKt.nullOutSpilledVariable(title);
                c00132.L$7 = SpillingKt.nullOutSpilledVariable(script);
                c00132.L$8 = SpillingKt.nullOutSpilledVariable(unpacked2);
                c00132.L$9 = m3u8;
                c00132.L$10 = fileName;
                c00132.L$11 = function6;
                c00132.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, title5, m3u8, infer_type2, c00143, c00132);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                m3u9 = m3u8;
                function8 = function7;
                res2 = res;
                html2 = html;
                html3 = fileName;
                function9 = function6;
                function10 = function9;
                html4 = title;
                title2 = script;
                unpacked3 = unpacked2;
                function9.invoke(objNewExtractorLink);
                if (StringsKt.contains$default(m3u9, "/stream/", false, 2, (Object) null)) {
                    m3u10 = m3u9;
                    String fileName4 = html3;
                    String mp4Url3 = StringsKt.substringBeforeLast$default(StringsKt.replace$default(m3u9, "/stream/", "/mp4/", false, 4, (Object) null), "/", (String) null, 2, (Object) null) + "?file=" + CodecsKt.encodeURLQueryComponent$default(html3, false, false, (Charset) null, 7, (Object) null);
                    String name4 = getName();
                    String str5 = getName() + " [Download]";
                    ExtractorLinkType extractorLinkType2 = ExtractorLinkType.VIDEO;
                    unpacked4 = unpacked3;
                    C00153 c00154 = new C00153(url2, fileName4, this, null);
                    c00132.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00132.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00132.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00132.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                    c00132.L$4 = SpillingKt.nullOutSpilledVariable(res2);
                    c00132.L$5 = SpillingKt.nullOutSpilledVariable(html2);
                    c00132.L$6 = SpillingKt.nullOutSpilledVariable(html4);
                    c00132.L$7 = SpillingKt.nullOutSpilledVariable(title2);
                    c00132.L$8 = SpillingKt.nullOutSpilledVariable(unpacked4);
                    c00132.L$9 = SpillingKt.nullOutSpilledVariable(m3u10);
                    c00132.L$10 = SpillingKt.nullOutSpilledVariable(fileName4);
                    c00132.L$11 = SpillingKt.nullOutSpilledVariable(mp4Url3);
                    c00132.L$12 = function10;
                    c00132.label = 3;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name4, str5, mp4Url3, extractorLinkType2, c00154, c00132);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    unpacked5 = unpacked4;
                    obj5 = objNewExtractorLink2;
                    script2 = title2;
                    function11 = function10;
                    function12 = function11;
                    title3 = html4;
                    mp4Url = m3u10;
                    fileName2 = html3;
                    res3 = res2;
                    function13 = function8;
                    function11.invoke(obj5);
                }
                return Unit.INSTANCE;
            case 2:
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00132.L$11;
                String fileName5 = (String) c00132.L$10;
                String m3u11 = (String) c00132.L$9;
                String unpacked8 = (String) c00132.L$8;
                String script3 = (String) c00132.L$7;
                String title6 = (String) c00132.L$6;
                String html5 = (String) c00132.L$5;
                NiceResponse res4 = (NiceResponse) c00132.L$4;
                function10 = (Function1) c00132.L$3;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c00132.L$2;
                String referer4 = (String) c00132.L$1;
                String url4 = (String) c00132.L$0;
                ResultKt.throwOnFailure($result);
                m3u9 = m3u11;
                unpacked3 = unpacked8;
                title2 = script3;
                res2 = res4;
                function8 = function15;
                html2 = html5;
                referer3 = referer4;
                url2 = url4;
                html4 = title6;
                function9 = function14;
                html3 = fileName5;
                objNewExtractorLink = $result;
                function9.invoke(objNewExtractorLink);
                if (StringsKt.contains$default(m3u9, "/stream/", false, 2, (Object) null)) {
                    m3u10 = m3u9;
                    String fileName6 = html3;
                    String mp4Url4 = StringsKt.substringBeforeLast$default(StringsKt.replace$default(m3u9, "/stream/", "/mp4/", false, 4, (Object) null), "/", (String) null, 2, (Object) null) + "?file=" + CodecsKt.encodeURLQueryComponent$default(html3, false, false, (Charset) null, 7, (Object) null);
                    String name5 = getName();
                    String str6 = getName() + " [Download]";
                    ExtractorLinkType extractorLinkType3 = ExtractorLinkType.VIDEO;
                    unpacked4 = unpacked3;
                    C00153 c00155 = new C00153(url2, fileName6, this, null);
                    c00132.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00132.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00132.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00132.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                    c00132.L$4 = SpillingKt.nullOutSpilledVariable(res2);
                    c00132.L$5 = SpillingKt.nullOutSpilledVariable(html2);
                    c00132.L$6 = SpillingKt.nullOutSpilledVariable(html4);
                    c00132.L$7 = SpillingKt.nullOutSpilledVariable(title2);
                    c00132.L$8 = SpillingKt.nullOutSpilledVariable(unpacked4);
                    c00132.L$9 = SpillingKt.nullOutSpilledVariable(m3u10);
                    c00132.L$10 = SpillingKt.nullOutSpilledVariable(fileName6);
                    c00132.L$11 = SpillingKt.nullOutSpilledVariable(mp4Url4);
                    c00132.L$12 = function10;
                    c00132.label = 3;
                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(name5, str6, mp4Url4, extractorLinkType3, c00155, c00132);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    unpacked5 = unpacked4;
                    obj5 = objNewExtractorLink2;
                    script2 = title2;
                    function11 = function10;
                    function12 = function11;
                    title3 = html4;
                    mp4Url = m3u10;
                    fileName2 = html3;
                    res3 = res2;
                    function13 = function8;
                    function11.invoke(obj5);
                }
                return Unit.INSTANCE;
            case 3:
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00132.L$12;
                fileName2 = (String) c00132.L$10;
                mp4Url = (String) c00132.L$9;
                unpacked5 = (String) c00132.L$8;
                script2 = (String) c00132.L$7;
                title3 = (String) c00132.L$6;
                res3 = (NiceResponse) c00132.L$4;
                Function1<? super ExtractorLink, Unit> function17 = (Function1) c00132.L$3;
                function13 = (Function1) c00132.L$2;
                ResultKt.throwOnFailure($result);
                obj5 = $result;
                function12 = function17;
                function11 = function16;
                function11.invoke(obj5);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Kwik$getUrl$2 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Kwik$getUrl$2", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00142 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $title;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00142(String str, Continuation<? super C00142> continuation) {
            super(2, continuation);
            this.$title = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00142 = Kwik.this.new C00142(this.$title, continuation);
            c00142.L$0 = obj;
            return c00142;
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
                    $this$newExtractorLink.setReferer(Kwik.this.getMainUrl());
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$title));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("origin", Kwik.this.getMainUrl())));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Kwik$getUrl$3 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Kwik$getUrl$3", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00153 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Kwik this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00153(String str, String str2, Kwik kwik, Continuation<? super C00153> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$fileName = str2;
            this.this$0 = kwik;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00153 = new C00153(this.$url, this.$fileName, this.this$0, continuation);
            c00153.L$0 = obj;
            return c00153;
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
                    $this$newExtractorLink.setReferer(this.$url);
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$fileName));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("Referer", this.$url), TuplesKt.to("Origin", this.this$0.getMainUrl())}));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
