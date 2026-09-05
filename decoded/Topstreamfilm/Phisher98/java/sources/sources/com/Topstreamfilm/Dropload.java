package com.Topstreamfilm;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Topstreamfilm/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/Topstreamfilm/Dropload;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Topstreamfilm"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/Topstreamfilm/Dropload\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n2068#2,2:62\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/Topstreamfilm/Dropload\n*L\n59#1:62,2\n*E\n"})
public class Dropload extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Dropload";

    @NotNull
    private final String mainUrl = "https://dropload.io";

    /* JADX INFO: renamed from: com.Topstreamfilm.Dropload$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.Dropload", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {49, 54}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "res", "script", "unpacked", "m3u8", "headers"}, nl = {50, 59}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Dropload.getUrl$suspendImpl(Dropload.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:20:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:21:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:28:0x0126  */
    /* JADX WARN: Code duplicated, block: B:31:0x01a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x01c1 A[LOOP:0: B:34:0x01bb->B:36:0x01c1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Dropload $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00001 c00001;
        Object obj;
        int i;
        Dropload $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String script;
        MatchResult matchResultFind$default;
        String str;
        Function1<? super ExtractorLink, Unit> function5;
        Object objGenerateM3u8$default;
        List groupValues;
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
                Requests app = MainActivityKt.getApp();
                c00002.L$0 = $this;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$4 = function2;
                c00002.label = 1;
                obj = coroutine_suspended;
                i = 1;
                Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                c00002 = c00002;
                if (obj3 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj3;
                function4 = function2;
                NiceResponse res = (NiceResponse) obj2;
                elementSelectFirst = res.getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    script = elementSelectFirst.data();
                } else {
                    script = null;
                }
                String unpacked = String.valueOf(new JsUnpacker(script).unpack());
                matchResultFind$default = Regex.find$default(new Regex("file:\"(.*?m3u8.*?)\""), unpacked, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, i)) == null) {
                    str = "";
                }
                String m3u8 = str;
                Map headers = MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"));
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String script2 = script;
                String script3 = $this2.getName();
                String str2 = $this2.getMainUrl() + '/';
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(res);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(script2);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(unpacked);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(headers);
                c00002.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, script3, m3u8, str2, (Integer) null, headers, (String) null, c00002, 40, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                for (Object element$iv : $this$forEach$iv) {
                    function5.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00002.L$4;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c00002.L$3;
                String referer3 = (String) c00002.L$2;
                String url3 = (String) c00002.L$1;
                Dropload $this3 = (Dropload) c00002.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                function4 = function6;
                function3 = function7;
                referer2 = referer3;
                url2 = url3;
                i = 1;
                obj2 = $result;
                NiceResponse res2 = (NiceResponse) obj2;
                elementSelectFirst = res2.getDocument().selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    script = elementSelectFirst.data();
                } else {
                    script = null;
                }
                String unpacked2 = String.valueOf(new JsUnpacker(script).unpack());
                matchResultFind$default = Regex.find$default(new Regex("file:\"(.*?m3u8.*?)\""), unpacked2, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    str = "";
                } else {
                    str = "";
                }
                String m3u9 = str;
                Map headers2 = MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"));
                M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                String script4 = script;
                String script5 = $this2.getName();
                String str3 = $this2.getMainUrl() + '/';
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(res2);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(script4);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(unpacked2);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(headers2);
                c00002.label = 2;
                function5 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion2, script5, m3u9, str3, (Integer) null, headers2, (String) null, c00002, 40, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                while (r14.hasNext()) {
                    function5.invoke(element$iv);
                }
                return Unit.INSTANCE;
            case 2:
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00002.L$4;
                ResultKt.throwOnFailure($result);
                function5 = function8;
                objGenerateM3u8$default = $result;
                Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                while (r14.hasNext()) {
                    function5.invoke(element$iv);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
