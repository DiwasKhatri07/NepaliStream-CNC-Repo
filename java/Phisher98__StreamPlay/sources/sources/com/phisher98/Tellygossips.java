package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
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

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Tellygossips;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "referer", "getUrl", "", "url", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Tellygossips extends ExtractorApi {

    @NotNull
    private final String mainUrl = "https://flow.tellygossips.net";

    @NotNull
    private final String name = "Tellygossips";

    @NotNull
    private final String referer = "http://tellygossips.net/";
    private final boolean requiresReferer;

    /* JADX INFO: renamed from: com.phisher98.Tellygossips$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Tellygossips", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {840, 843}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "doc", "link"}, nl = {841, 842}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C02981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C02981(Continuation<? super C02981> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Tellygossips.this.getUrl(null, null, null, null, (Continuation) this);
        }
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

    /* JADX WARN: Code duplicated, block: B:20:0x0115 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0116  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C02981 c02981;
        Object obj;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object objNewExtractorLink;
        Object obj3;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C02981) {
            c02981 = (C02981) continuation;
            if ((c02981.label & Integer.MIN_VALUE) != 0) {
                c02981.label -= Integer.MIN_VALUE;
            } else {
                c02981 = new C02981(continuation);
            }
        } else {
            c02981 = new C02981(continuation);
        }
        C02981 c02982 = c02981;
        Object $result = c02982.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02982.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = this.referer;
                c02982.L$0 = url;
                c02982.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c02982.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c02982.L$3 = function2;
                c02982.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, str, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02982, 4090, (Object) null);
                c02982 = c02982;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                String doc = ((NiceResponse) obj2).getText();
                String link = StringsKt.substringBefore$default(StringsKt.substringAfter$default(doc, "src\":\"", (String) null, 2, (Object) null), "\",", (String) null, 2, (Object) null);
                String link2 = getName();
                String name = getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C02992 c02992 = new C02992(url2, null);
                c02982.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02982.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c02982.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c02982.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c02982.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                c02982.L$5 = SpillingKt.nullOutSpilledVariable(link);
                c02982.L$6 = function4;
                c02982.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(link2, name, link, infer_type, c02992, c02982);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                obj3 = objNewExtractorLink;
                function5 = function4;
                function5.invoke(obj3);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c02982.L$3;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c02982.L$2;
                String referer3 = (String) c02982.L$1;
                String url3 = (String) c02982.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function4 = function6;
                function3 = function7;
                referer2 = referer3;
                url2 = url3;
                obj2 = $result;
                String doc2 = ((NiceResponse) obj2).getText();
                String link3 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(doc2, "src\":\"", (String) null, 2, (Object) null), "\",", (String) null, 2, (Object) null);
                String link4 = getName();
                String name2 = getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C02992 c02993 = new C02992(url2, null);
                c02982.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02982.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                c02982.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c02982.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c02982.L$4 = SpillingKt.nullOutSpilledVariable(doc2);
                c02982.L$5 = SpillingKt.nullOutSpilledVariable(link3);
                c02982.L$6 = function4;
                c02982.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(link4, name2, link3, infer_type2, c02993, c02982);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                obj3 = objNewExtractorLink;
                function5 = function4;
                function5.invoke(obj3);
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c02982.L$6;
                ResultKt.throwOnFailure($result);
                obj3 = $result;
                function5.invoke(obj3);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Tellygossips$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Tellygossips$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C02992 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02992(String str, Continuation<? super C02992> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02992 = new C02992(this.$url, continuation);
            c02992.L$0 = obj;
            return c02992;
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
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
