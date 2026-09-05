package com.phisher98;

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
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Embedrise;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Embedrise extends ExtractorApi {

    @NotNull
    private final String name = "Embedrise";

    @NotNull
    private final String mainUrl = "https://embedrise.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Embedrise$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Embedrise", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {661, 666}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "res", "title", "video"}, nl = {662, 665}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00151 extends ContinuationImpl {
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

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Embedrise.getUrl$suspendImpl(Embedrise.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:20:0x013b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x013c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Embedrise $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00151 c00151;
        Object obj;
        Object obj2;
        Embedrise $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = $this.new C00151(continuation);
            }
        } else {
            c00151 = $this.new C00151(continuation);
        }
        C00151 c00152 = c00151;
        Object $result = c00152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00152.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00152.L$0 = $this;
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00152.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00152.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00152.L$4 = function2;
                c00152.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00152, 4090, (Object) null);
                c00152 = c00152;
                if (obj2 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                Document res = ((NiceResponse) obj2).getDocument();
                String title = res.select("title").text();
                String video = res.select("video#player source").attr("src");
                String name = $this2.getName();
                String name2 = $this2.getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00162 c00162 = $this2.new C00162(title, null);
                c00152.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00152.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00152.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00152.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00152.L$5 = SpillingKt.nullOutSpilledVariable(res);
                c00152.L$6 = SpillingKt.nullOutSpilledVariable(title);
                c00152.L$7 = SpillingKt.nullOutSpilledVariable(video);
                c00152.L$8 = function4;
                c00152.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video, infer_type, c00162, c00152);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00152.L$4;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c00152.L$3;
                String referer3 = (String) c00152.L$2;
                String url3 = (String) c00152.L$1;
                Embedrise $this3 = (Embedrise) c00152.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                function4 = function6;
                function3 = function7;
                referer2 = referer3;
                url2 = url3;
                obj2 = $result;
                Document res2 = ((NiceResponse) obj2).getDocument();
                String title2 = res2.select("title").text();
                String video2 = res2.select("video#player source").attr("src");
                String name3 = $this2.getName();
                String name4 = $this2.getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00162 c00163 = $this2.new C00162(title2, null);
                c00152.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00152.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00152.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00152.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00152.L$5 = SpillingKt.nullOutSpilledVariable(res2);
                c00152.L$6 = SpillingKt.nullOutSpilledVariable(title2);
                c00152.L$7 = SpillingKt.nullOutSpilledVariable(video2);
                c00152.L$8 = function4;
                c00152.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, video2, infer_type2, c00163, c00152);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c00152.L$8;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function5.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Embedrise$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Embedrise$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00162 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $title;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00162(String str, Continuation<? super C00162> continuation) {
            super(2, continuation);
            this.$title = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00162 = Embedrise.this.new C00162(this.$title, continuation);
            c00162.L$0 = obj;
            return c00162;
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
                    $this$newExtractorLink.setReferer(Embedrise.this.getMainUrl() + '/');
                    $this$newExtractorLink.setQuality(StreamPlayUtilsKt.getIndexQuality(this.$title));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
