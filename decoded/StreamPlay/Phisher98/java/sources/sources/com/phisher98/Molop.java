package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
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
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Molop;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Molop\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n2068#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Molop\n*L\n2311#1:4004,2\n*E\n"})
public final class Molop extends ExtractorApi {

    @NotNull
    private final String name = "Molop";

    @NotNull
    private final String mainUrl = "https://molop.art";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Molop$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Molop", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2301, 2311}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "headers", "url", "referer", "subtitleCallback", "callback", "headers", "res", "sniffScript", "cleaned", "regex", "args", "token", "m3u8"}, nl = {2302, 4004}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00481 extends ContinuationImpl {
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

        C00481(Continuation<? super C00481> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Molop.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:37:0x021c A[LOOP:0: B:35:0x0216->B:37:0x021c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00481 c00481;
        Molop molop;
        Object obj;
        int i;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Map headers;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String strData;
        String strSubstringAfter$default;
        String sniffScript;
        Object objGenerateM3u8$default;
        Function1<? super ExtractorLink, Unit> function5;
        Iterable $this$forEach$iv;
        if (continuation instanceof C00481) {
            c00481 = (C00481) continuation;
            if ((c00481.label & Integer.MIN_VALUE) != 0) {
                c00481.label -= Integer.MIN_VALUE;
                molop = this;
            } else {
                molop = this;
                c00481 = molop.new C00481(continuation);
            }
        } else {
            molop = this;
            c00481 = molop.new C00481(continuation);
        }
        C00481 c00482 = c00481;
        Object $result = c00482.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00482.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map headers2 = MapsKt.mapOf(TuplesKt.to("user-agent", "okhttp/4.12.0"));
                Requests app = MainActivityKt.getApp();
                c00482.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00482.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00482.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00482.L$3 = function2;
                c00482.L$4 = headers2;
                c00482.label = 1;
                obj = coroutine_suspended;
                i = 1;
                Object obj3 = Requests.get$default(app, url, headers2, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00482, 4088, (Object) null);
                c00482 = c00482;
                if (obj3 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj3;
                headers = headers2;
                function4 = function2;
                Document res = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(sniff\\()");
                if (elementSelectFirst != null || (strData = elementSelectFirst.data()) == null || (strSubstringAfter$default = StringsKt.substringAfter$default(strData, "sniff(", (String) null, 2, (Object) null)) == null || (sniffScript = StringsKt.substringBefore$default(strSubstringAfter$default, ");", (String) null, 2, (Object) null)) == null) {
                    return Unit.INSTANCE;
                }
                String cleaned = new Regex("\\[.*?]").replace(sniffScript, "");
                Regex regex = new Regex("\"(.*?)\"");
                List args = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(regex, cleaned, 0, 2, (Object) null), new Function1() { // from class: com.phisher98.Molop$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj4) {
                        return StringsKt.trim((String) ((MatchResult) obj4).getGroupValues().get(1)).toString();
                    }
                }));
                String str = (String) CollectionsKt.lastOrNull(args);
                String token = str != null ? str : "";
                String m3u8 = molop.getMainUrl() + "/m3u8/" + ((String) args.get(i)) + '/' + ((String) args.get(2)) + "/master.txt?s=1&cache=1&plt=" + token;
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String name = molop.getName();
                String mainUrl = molop.getMainUrl();
                c00482.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00482.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c00482.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00482.L$3 = function4;
                c00482.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                c00482.L$5 = SpillingKt.nullOutSpilledVariable(res);
                c00482.L$6 = SpillingKt.nullOutSpilledVariable(sniffScript);
                c00482.L$7 = SpillingKt.nullOutSpilledVariable(cleaned);
                c00482.L$8 = SpillingKt.nullOutSpilledVariable(regex);
                c00482.L$9 = SpillingKt.nullOutSpilledVariable(args);
                c00482.L$10 = SpillingKt.nullOutSpilledVariable(token);
                c00482.L$11 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00482.label = 2;
                Function1<? super ExtractorLink, Unit> function6 = function4;
                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, name, m3u8, mainUrl, (Integer) null, headers, (String) null, c00482, 40, (Object) null);
                if (objGenerateM3u8$default == obj) {
                    return obj;
                }
                function5 = function6;
                $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                for (Object element$iv : $this$forEach$iv) {
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    function5.invoke(element$iv);
                    $this$forEach$iv = $this$forEach$iv2;
                }
                return Unit.INSTANCE;
            case 1:
                Map headers3 = (Map) c00482.L$4;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00482.L$3;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00482.L$2;
                String referer3 = (String) c00482.L$1;
                String url3 = (String) c00482.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                referer2 = referer3;
                url2 = url3;
                headers = headers3;
                i = 1;
                obj2 = $result;
                Document res2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = res2.selectFirst("script:containsData(sniff\\()");
                if (elementSelectFirst != null) {
                }
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c00482.L$3;
                ResultKt.throwOnFailure($result);
                objGenerateM3u8$default = $result;
                $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                while (r3.hasNext()) {
                    Iterable $this$forEach$iv3 = $this$forEach$iv;
                    function5.invoke(element$iv);
                    $this$forEach$iv = $this$forEach$iv3;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
