package com.Desicinemas;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tvlogy.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Desicinemas/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/Desicinemas/Tvlogyflow;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "source", "", "<init>", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "proxyUrl", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Desicinemas"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Tvlogyflow extends ExtractorApi {

    @NotNull
    private final String mainUrl = "https://flow.tvlogy.to";

    @NotNull
    private final String name = "Tvlogy";

    @NotNull
    private final String proxyUrl = "https://proxy.phisher2.workers.dev/?url=";
    private final boolean requiresReferer;

    @NotNull
    private final String source;

    /* JADX INFO: renamed from: com.Desicinemas.Tvlogyflow$getUrl$1 */
    /* JADX INFO: compiled from: Tvlogy.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.Tvlogyflow", f = "Tvlogy.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {107, 108, 112, 113}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "directDoc", "url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "proxyDoc"}, nl = {108, 109, 113, 114}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Tvlogyflow.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    public Tvlogyflow(@NotNull String source) {
        this.source = source;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0135 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x013e A[Catch: Exception -> 0x0148, TRY_LEAVE, TryCatch #3 {Exception -> 0x0148, blocks: (B:41:0x0136, B:43:0x013e, B:38:0x0110), top: B:79:0x0110 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0141  */
    /* JADX WARN: Code duplicated, block: B:59:0x01cf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:63:0x0205 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00171 c00171;
        Object obj;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        String url2;
        Function1<? super ExtractorLink, Unit> function4;
        String url3;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String referer3;
        String referer4;
        Function1<? super ExtractorLink, Unit> function7;
        String url4;
        String referer5;
        Function1<? super SubtitleFile, Unit> function8;
        Function1<? super ExtractorLink, Unit> function9;
        String proxyDoc;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
            } else {
                c00171 = new C00171(continuation);
            }
        } else {
            c00171 = new C00171(continuation);
        }
        C00171 c00172 = c00171;
        Object $result = c00172.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00172.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Requests app = UtilsKt.getApp();
                        String mainUrl = getMainUrl();
                        c00172.L$0 = url;
                        c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                        c00172.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                        c00172.L$3 = function2;
                        c00172.label = 1;
                        obj = coroutine_suspended;
                        try {
                            Object obj2 = Requests.get$default(app, url, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00172, 4090, (Object) null);
                            c00172 = c00172;
                            if (obj2 == obj) {
                                return obj;
                            }
                            url4 = url;
                            referer5 = referer;
                            function8 = function1;
                            function9 = function2;
                            $result = obj2;
                            try {
                                String directDoc = ((NiceResponse) $result).getText();
                                c00172.L$0 = url4;
                                c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                                c00172.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00172.L$3 = function9;
                                c00172.L$4 = SpillingKt.nullOutSpilledVariable(directDoc);
                                c00172.label = 2;
                                $result = getUrl$process(function9, this, directDoc, c00172);
                                if ($result == obj) {
                                    return obj;
                                }
                                if (((Boolean) $result).booleanValue()) {
                                    return Unit.INSTANCE;
                                }
                                function4 = function9;
                                function3 = function8;
                                referer2 = referer5;
                                url2 = url4;
                                try {
                                    Requests app2 = UtilsKt.getApp();
                                    String str = this.proxyUrl + url2;
                                    String mainUrl2 = getMainUrl();
                                    c00172.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                    c00172.L$3 = function4;
                                    c00172.L$4 = null;
                                    c00172.label = 3;
                                    url3 = url2;
                                    function5 = function4;
                                    C00171 c00173 = c00172;
                                    try {
                                        $result = Requests.get$default(app2, str, (Map) null, mainUrl2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00173, 4090, (Object) null);
                                        c00172 = c00173;
                                        if ($result == obj) {
                                            return obj;
                                        }
                                        function6 = function3;
                                        referer3 = referer2;
                                        referer4 = url3;
                                        function7 = function5;
                                        try {
                                            proxyDoc = ((NiceResponse) $result).getText();
                                            c00172.L$0 = SpillingKt.nullOutSpilledVariable(referer4);
                                            c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                            c00172.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                            c00172.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00172.L$4 = SpillingKt.nullOutSpilledVariable(proxyDoc);
                                            c00172.label = 4;
                                            if (getUrl$process(function7, this, proxyDoc, c00172) == obj) {
                                                return obj;
                                            }
                                        } catch (Exception e) {
                                        }
                                        return Unit.INSTANCE;
                                    } catch (Exception e2) {
                                    }
                                } catch (Exception e3) {
                                }
                            } catch (Exception e4) {
                                function4 = function9;
                                function3 = function8;
                                referer2 = referer5;
                                url2 = url4;
                            }
                        } catch (Exception e5) {
                            c00172 = c00172;
                            url4 = url;
                            referer5 = referer;
                            function8 = function1;
                            function9 = function2;
                            function4 = function9;
                            function3 = function8;
                            referer2 = referer5;
                            url2 = url4;
                        }
                    } catch (Exception e6) {
                        obj = coroutine_suspended;
                        url4 = url;
                        referer5 = referer;
                        function8 = function1;
                        function9 = function2;
                    }
                    break;
                case 1:
                    function9 = (Function1) c00172.L$3;
                    function8 = (Function1) c00172.L$2;
                    referer5 = (String) c00172.L$1;
                    url4 = (String) c00172.L$0;
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    String directDoc2 = ((NiceResponse) $result).getText();
                    c00172.L$0 = url4;
                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer5);
                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00172.L$3 = function9;
                    c00172.L$4 = SpillingKt.nullOutSpilledVariable(directDoc2);
                    c00172.label = 2;
                    $result = getUrl$process(function9, this, directDoc2, c00172);
                    if ($result == obj) {
                        return obj;
                    }
                    if (((Boolean) $result).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    function4 = function9;
                    function3 = function8;
                    referer2 = referer5;
                    url2 = url4;
                    Requests app3 = UtilsKt.getApp();
                    String str2 = this.proxyUrl + url2;
                    String mainUrl3 = getMainUrl();
                    c00172.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00172.L$3 = function4;
                    c00172.L$4 = null;
                    c00172.label = 3;
                    url3 = url2;
                    function5 = function4;
                    C00171 c00174 = c00172;
                    $result = Requests.get$default(app3, str2, (Map) null, mainUrl3, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00174, 4090, (Object) null);
                    c00172 = c00174;
                    if ($result == obj) {
                        return obj;
                    }
                    function6 = function3;
                    referer3 = referer2;
                    referer4 = url3;
                    function7 = function5;
                    proxyDoc = ((NiceResponse) $result).getText();
                    c00172.L$0 = SpillingKt.nullOutSpilledVariable(referer4);
                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c00172.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    c00172.L$4 = SpillingKt.nullOutSpilledVariable(proxyDoc);
                    c00172.label = 4;
                    if (getUrl$process(function7, this, proxyDoc, c00172) == obj) {
                        return obj;
                    }
                    return Unit.INSTANCE;
                case 2:
                    function9 = (Function1) c00172.L$3;
                    function8 = (Function1) c00172.L$2;
                    referer5 = (String) c00172.L$1;
                    url4 = (String) c00172.L$0;
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    if (((Boolean) $result).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    function4 = function9;
                    function3 = function8;
                    referer2 = referer5;
                    url2 = url4;
                    Requests app4 = UtilsKt.getApp();
                    String str3 = this.proxyUrl + url2;
                    String mainUrl4 = getMainUrl();
                    c00172.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00172.L$3 = function4;
                    c00172.L$4 = null;
                    c00172.label = 3;
                    url3 = url2;
                    function5 = function4;
                    C00171 c00175 = c00172;
                    $result = Requests.get$default(app4, str3, (Map) null, mainUrl4, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00175, 4090, (Object) null);
                    c00172 = c00175;
                    if ($result == obj) {
                        return obj;
                    }
                    function6 = function3;
                    referer3 = referer2;
                    referer4 = url3;
                    function7 = function5;
                    proxyDoc = ((NiceResponse) $result).getText();
                    c00172.L$0 = SpillingKt.nullOutSpilledVariable(referer4);
                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c00172.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    c00172.L$4 = SpillingKt.nullOutSpilledVariable(proxyDoc);
                    c00172.label = 4;
                    if (getUrl$process(function7, this, proxyDoc, c00172) == obj) {
                        return obj;
                    }
                    return Unit.INSTANCE;
                case 3:
                    Function1<? super ExtractorLink, Unit> function10 = (Function1) c00172.L$3;
                    Function1<? super SubtitleFile, Unit> function11 = (Function1) c00172.L$2;
                    String referer6 = (String) c00172.L$1;
                    String url5 = (String) c00172.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj = coroutine_suspended;
                        function7 = function10;
                        function6 = function11;
                        referer3 = referer6;
                        referer4 = url5;
                        proxyDoc = ((NiceResponse) $result).getText();
                        c00172.L$0 = SpillingKt.nullOutSpilledVariable(referer4);
                        c00172.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00172.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c00172.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        c00172.L$4 = SpillingKt.nullOutSpilledVariable(proxyDoc);
                        c00172.label = 4;
                        if (getUrl$process(function7, this, proxyDoc, c00172) == obj) {
                            return obj;
                        }
                    } catch (Exception e7) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    try {
                        ResultKt.throwOnFailure($result);
                    } catch (Exception e8) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e9) {
            obj = coroutine_suspended;
        }
    }

    private static final String getUrl$extractJuicy(String doc) {
        List groupValues;
        String juicy;
        List groupValues2;
        try {
            MatchResult matchResultFind$default = Regex.find$default(new Regex("JuicyCodes\\.Run\\(\"(.*?)\"\\);"), doc, 0, 2, (Object) null);
            if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (juicy = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
                return null;
            }
            String encoded = new Regex("\\s").replace(StringsKt.replace$default(StringsKt.replace$default(juicy, "\"", "", false, 4, (Object) null), "+", "", false, 4, (Object) null), "");
            String decoded = MainAPIKt.base64Decode(encoded);
            String unpacked = decoded;
            MatchResult packedMatch = Regex.find$default(new Regex("\\}\\('(.*)',\\d+,\\d+,'(.*)'\\.split"), decoded, 0, 2, (Object) null);
            if (packedMatch != null) {
                String payload = (String) packedMatch.getGroupValues().get(1);
                final List symtab = StringsKt.split$default((CharSequence) packedMatch.getGroupValues().get(2), new String[]{"|"}, false, 0, 6, (Object) null);
                unpacked = new Regex("\\b(\\w+)\\b").replace(payload, new Function1() { // from class: com.Desicinemas.Tvlogyflow$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return Tvlogyflow.getUrl$extractJuicy$lambda$0(symtab, (MatchResult) obj);
                    }
                });
            }
            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("file\":\\s*\"(.*?)\""), unpacked, 0, 2, (Object) null);
            if (matchResultFind$default2 == null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null) {
                return null;
            }
            return (String) CollectionsKt.getOrNull(groupValues2, 1);
        } catch (Exception e) {
            return null;
        }
    }

    static final CharSequence getUrl$extractJuicy$lambda$0(List $symtab, MatchResult match) {
        Integer index = StringsKt.toIntOrNull(match.getValue(), 36);
        return (CharSequence) ((index == null || index.intValue() >= $symtab.size()) ? match.getValue() : $symtab.get(index.intValue()));
    }

    private static final String getUrl$extractDirect(String doc) {
        List groupValues;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("\"src\"\\s*:\\s*\"(https?://.*?\\.m3u8.*?)\""), doc, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return (String) CollectionsKt.getOrNull(groupValues, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object getUrl$process(Function1<? super ExtractorLink, Unit> function1, Tvlogyflow this$0, String doc, Continuation<? super Boolean> continuation) {
        Tvlogyflow$getUrl$process$1 tvlogyflow$getUrl$process$1;
        Object obj;
        Object obj2;
        if (continuation instanceof Tvlogyflow$getUrl$process$1) {
            tvlogyflow$getUrl$process$1 = (Tvlogyflow$getUrl$process$1) continuation;
            if ((tvlogyflow$getUrl$process$1.label & Integer.MIN_VALUE) != 0) {
                tvlogyflow$getUrl$process$1.label -= Integer.MIN_VALUE;
            } else {
                tvlogyflow$getUrl$process$1 = new Tvlogyflow$getUrl$process$1(continuation);
            }
        } else {
            tvlogyflow$getUrl$process$1 = new Tvlogyflow$getUrl$process$1(continuation);
        }
        Tvlogyflow$getUrl$process$1 tvlogyflow$getUrl$process$2 = tvlogyflow$getUrl$process$1;
        Object $result = tvlogyflow$getUrl$process$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tvlogyflow$getUrl$process$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String direct = getUrl$extractDirect(doc);
                String str = direct;
                if (!(str == null || str.length() == 0)) {
                    String str2 = this$0.getName() + ' ' + this$0.source;
                    String name = this$0.getName();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    Tvlogyflow$getUrl$process$2 tvlogyflow$getUrl$process$3 = new Tvlogyflow$getUrl$process$2(this$0, null);
                    tvlogyflow$getUrl$process$2.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                    tvlogyflow$getUrl$process$2.L$1 = SpillingKt.nullOutSpilledVariable(this$0);
                    tvlogyflow$getUrl$process$2.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                    tvlogyflow$getUrl$process$2.L$3 = SpillingKt.nullOutSpilledVariable(direct);
                    tvlogyflow$getUrl$process$2.L$4 = function1;
                    tvlogyflow$getUrl$process$2.label = 1;
                    Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(str2, name, direct, infer_type, tvlogyflow$getUrl$process$3, tvlogyflow$getUrl$process$2);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objNewExtractorLink;
                    function1.invoke(obj2);
                    return Boxing.boxBoolean(true);
                }
                String juicy = getUrl$extractJuicy(doc);
                String str3 = juicy;
                if (!(str3 == null || str3.length() == 0)) {
                    String str4 = this$0.getName() + ' ' + this$0.source;
                    String name2 = this$0.getName();
                    ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                    Tvlogyflow$getUrl$process$3 tvlogyflow$getUrl$process$4 = new Tvlogyflow$getUrl$process$3(this$0, null);
                    tvlogyflow$getUrl$process$2.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                    tvlogyflow$getUrl$process$2.L$1 = SpillingKt.nullOutSpilledVariable(this$0);
                    tvlogyflow$getUrl$process$2.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                    tvlogyflow$getUrl$process$2.L$3 = SpillingKt.nullOutSpilledVariable(direct);
                    tvlogyflow$getUrl$process$2.L$4 = SpillingKt.nullOutSpilledVariable(juicy);
                    tvlogyflow$getUrl$process$2.L$5 = function1;
                    tvlogyflow$getUrl$process$2.label = 2;
                    Object objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(str4, name2, juicy, infer_type2, tvlogyflow$getUrl$process$4, tvlogyflow$getUrl$process$2);
                    if (objNewExtractorLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objNewExtractorLink2;
                    function1.invoke(obj);
                    return Boxing.boxBoolean(true);
                }
                return Boxing.boxBoolean(false);
            case 1:
                Function1<? super ExtractorLink, Unit> function2 = (Function1) tvlogyflow$getUrl$process$2.L$4;
                ResultKt.throwOnFailure($result);
                function1 = function2;
                obj2 = $result;
                function1.invoke(obj2);
                return Boxing.boxBoolean(true);
            case 2:
                Function1<? super ExtractorLink, Unit> function3 = (Function1) tvlogyflow$getUrl$process$2.L$5;
                ResultKt.throwOnFailure($result);
                function1 = function3;
                obj = $result;
                function1.invoke(obj);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
