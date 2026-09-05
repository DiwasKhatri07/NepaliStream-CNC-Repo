package com.Topstreamfilm;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Topstreamfilm/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/Topstreamfilm/SuperVideo;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Topstreamfilm"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/Topstreamfilm/SuperVideo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n2068#2,2:62\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/Topstreamfilm/SuperVideo\n*L\n32#1:62,2\n*E\n"})
public class SuperVideo extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "SuperVideo";

    @NotNull
    private final String mainUrl = "https://supervideo.tv";

    /* JADX INFO: renamed from: com.Topstreamfilm.SuperVideo$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.SuperVideo", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {23, 28}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "res", "script", "unpacked", "m3u8"}, nl = {25, 32}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuperVideo.getUrl$suspendImpl(SuperVideo.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:20:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:21:0x0101  */
    /* JADX WARN: Code duplicated, block: B:24:0x0106  */
    /* JADX WARN: Code duplicated, block: B:26:0x0109  */
    /* JADX WARN: Code duplicated, block: B:32:0x012e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0194 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0195  */
    /* JADX WARN: Code duplicated, block: B:40:0x01ad A[LOOP:0: B:38:0x01a7->B:40:0x01ad, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(SuperVideo $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00011 c00011;
        Object obj;
        int i;
        SuperVideo $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        NiceResponse res;
        Element elementSelectFirst;
        String strData;
        String script;
        MatchResult matchResultFind$default;
        String str;
        Function1<? super ExtractorLink, Unit> function5;
        Object objGenerateM3u8$default;
        Function1<? super ExtractorLink, Unit> function6;
        List groupValues;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = $this.new C00011(continuation);
            }
        } else {
            c00011 = $this.new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String strReplace$default = StringsKt.replace$default(url, "tv", "cc", false, 4, (Object) null);
                c00012.L$0 = $this;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00012.L$4 = function2;
                c00012.label = 1;
                obj = coroutine_suspended;
                i = 1;
                Object obj3 = Requests.get$default(app, strReplace$default, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4090, (Object) null);
                c00012 = c00012;
                if (obj3 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj3;
                function4 = function2;
                res = (NiceResponse) obj2;
                elementSelectFirst = res.getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                script = strData;
                if (script == null) {
                    return Unit.INSTANCE;
                }
                String unpacked = ExtractorApiKt.getAndUnpack(script);
                matchResultFind$default = Regex.find$default(new Regex("file:\"(.*?m3u8.*?)"), unpacked, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, i)) == null) {
                    str = "";
                }
                String m3u8 = str;
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String name = $this2.getName();
                String str2 = $this2.getMainUrl() + '/';
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00012.L$4 = function4;
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(res);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(unpacked);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00012.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, str2, (Integer) null, (Map) null, (String) null, c00012, 56, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                for (Object element$iv : $this$forEach$iv) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00012.L$4;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00012.L$3;
                String referer3 = (String) c00012.L$2;
                String url3 = (String) c00012.L$1;
                SuperVideo $this3 = (SuperVideo) c00012.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                referer2 = referer3;
                url2 = url3;
                i = 1;
                obj2 = $result;
                res = (NiceResponse) obj2;
                elementSelectFirst = res.getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                script = strData;
                if (script == null) {
                    return Unit.INSTANCE;
                }
                String unpacked2 = ExtractorApiKt.getAndUnpack(script);
                matchResultFind$default = Regex.find$default(new Regex("file:\"(.*?m3u8.*?)"), unpacked2, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = "";
                } else {
                    str = "";
                }
                String m3u9 = str;
                M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                String name2 = $this2.getName();
                String str3 = $this2.getMainUrl() + '/';
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00012.L$4 = function4;
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(res);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(unpacked2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00012.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion2, name2, m3u9, str3, (Integer) null, (Map) null, (String) null, c00012, 56, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function6 = function5;
                Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c00012.L$4;
                ResultKt.throwOnFailure($result);
                objGenerateM3u8$default = $result;
                Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                while (r12.hasNext()) {
                    function6.invoke(element$iv);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
