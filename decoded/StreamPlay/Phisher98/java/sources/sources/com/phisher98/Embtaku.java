package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
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
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/phisher98/Embtaku;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Embtaku extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private String name = "Embtaku";

    @NotNull
    private String mainUrl = "https://embtaku.pro";

    /* JADX INFO: renamed from: com.phisher98.Embtaku$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Embtaku", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {1606, 1608}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "responsecode", "serverRes"}, nl = {1607, 1612}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Embtaku.getUrl$suspendImpl(Embtaku.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:20:0x0118 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0119  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Embtaku $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00171 c00171;
        Embtaku $this2;
        Object obj;
        C00171 c00172;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00182 c00182;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
                $this2 = $this;
            } else {
                $this2 = $this;
                c00171 = $this2.new C00171(continuation);
            }
        } else {
            $this2 = $this;
            c00171 = $this2.new C00171(continuation);
        }
        Object $result = c00171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00171.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00171.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00171.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00171.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00171.L$3 = function1;
                c00171.L$4 = function2;
                c00171.label = 1;
                C00171 c00173 = c00171;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00173, 4094, (Object) null);
                c00172 = c00173;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                NiceResponse responsecode = (NiceResponse) $result;
                Document serverRes = responsecode.getDocument();
                listSelect = serverRes.select("ul.list-server-items");
                c00182 = new C00182(function3, function4, null);
                c00172.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00172.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00172.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00172.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00172.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00172.L$5 = SpillingKt.nullOutSpilledVariable(responsecode);
                c00172.L$6 = SpillingKt.nullOutSpilledVariable(serverRes);
                c00172.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00182, c00172) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                function4 = (Function1) c00171.L$4;
                function3 = (Function1) c00171.L$3;
                referer2 = (String) c00171.L$2;
                url2 = (String) c00171.L$1;
                $this2 = (Embtaku) c00171.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                c00172 = c00171;
                NiceResponse responsecode2 = (NiceResponse) $result;
                Document serverRes2 = responsecode2.getDocument();
                listSelect = serverRes2.select("ul.list-server-items");
                c00182 = new C00182(function3, function4, null);
                c00172.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00172.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00172.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00172.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00172.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00172.L$5 = SpillingKt.nullOutSpilledVariable(responsecode2);
                c00172.L$6 = SpillingKt.nullOutSpilledVariable(serverRes2);
                c00172.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00182, c00172) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Embtaku$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Embtaku$getUrl$2", f = "Extractors.kt", i = {0, 0}, l = {1610}, m = "invokeSuspend", n = {"it", "href"}, nl = {1611}, s = {"L$0", "L$1"}, v = 2)
    static final class C00182 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00182(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00182> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00182 = new C00182(this.$subtitleCallback, this.$callback, continuation);
            c00182.L$0 = obj;
            return c00182;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String href = it.attr("data-video");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                    this.label = 1;
                    if (StreamPlayUtilsKt.loadSourceNameExtractor$default("Anichi", href, "", this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
