package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/VCloudGDirect;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class VCloudGDirect extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "V-Cloud GD";

    @NotNull
    private final String mainUrl = "https://fastdl.icu";

    /* JADX INFO: renamed from: com.phisher98.VCloudGDirect$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.VCloudGDirect", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {296, 303}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "source"}, nl = {297, 302}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C03071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C03071(Continuation<? super C03071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VCloudGDirect.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:22:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:29:0x0133 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0134  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C03071 c03071;
        Object obj;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String strAttr;
        String source;
        Object objNewExtractorLink$default;
        Object obj3;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C03071) {
            c03071 = (C03071) continuation;
            if ((c03071.label & Integer.MIN_VALUE) != 0) {
                c03071.label -= Integer.MIN_VALUE;
            } else {
                c03071 = new C03071(continuation);
            }
        } else {
            c03071 = new C03071(continuation);
        }
        C03071 c03072 = c03071;
        Object $result = c03072.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03072.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c03072.L$0 = url;
                c03072.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c03072.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c03072.L$3 = function2;
                c03072.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03072, 4094, (Object) null);
                c03072 = c03072;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("#vd");
                if (elementSelectFirst != null || (strAttr = elementSelectFirst.attr("href")) == null) {
                    strAttr = "";
                }
                source = strAttr;
                if (StringsKt.isBlank(source)) {
                    Log.INSTANCE.e("Error:", "Failed to extract video link from " + url2);
                    return Unit.INSTANCE;
                }
                C03082 c03082 = new C03082(source, null);
                c03072.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03072.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c03072.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c03072.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c03072.L$4 = SpillingKt.nullOutSpilledVariable(source);
                c03072.L$5 = function4;
                c03072.label = 2;
                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("V-Cloud GD 10 Gbps", "V-Cloud GD 10 Gbps", source, (ExtractorLinkType) null, c03082, c03072, 8, (Object) null);
                if (objNewExtractorLink$default == obj) {
                    return obj;
                }
                obj3 = objNewExtractorLink$default;
                function5 = function4;
                function5.invoke(obj3);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c03072.L$3;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c03072.L$2;
                String referer3 = (String) c03072.L$1;
                String url3 = (String) c03072.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function4 = function6;
                function3 = function7;
                referer2 = referer3;
                url2 = url3;
                obj2 = $result;
                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("#vd");
                if (elementSelectFirst != null) {
                    strAttr = "";
                } else {
                    strAttr = "";
                }
                source = strAttr;
                if (StringsKt.isBlank(source)) {
                    Log.INSTANCE.e("Error:", "Failed to extract video link from " + url2);
                    return Unit.INSTANCE;
                }
                C03082 c03083 = new C03082(source, null);
                c03072.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03072.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c03072.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c03072.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c03072.L$4 = SpillingKt.nullOutSpilledVariable(source);
                c03072.L$5 = function4;
                c03072.label = 2;
                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default("V-Cloud GD 10 Gbps", "V-Cloud GD 10 Gbps", source, (ExtractorLinkType) null, c03083, c03072, 8, (Object) null);
                if (objNewExtractorLink$default == obj) {
                    return obj;
                }
                obj3 = objNewExtractorLink$default;
                function5 = function4;
                function5.invoke(obj3);
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c03072.L$5;
                ResultKt.throwOnFailure($result);
                obj3 = $result;
                function5.invoke(obj3);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.VCloudGDirect$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.VCloudGDirect$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03082 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $source;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03082(String str, Continuation<? super C03082> continuation) {
            super(2, continuation);
            this.$source = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c03082 = new C03082(this.$source, continuation);
            c03082.L$0 = obj;
            return c03082;
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
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$source));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
