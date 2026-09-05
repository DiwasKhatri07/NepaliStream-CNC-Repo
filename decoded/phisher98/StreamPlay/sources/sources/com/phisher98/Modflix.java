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
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Modflix;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "finallink", "quality", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Modflix extends ExtractorApi {

    @NotNull
    private final String name = "Modflix";

    @NotNull
    private final String mainUrl = "https://video-seed.xyz";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Modflix$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Modflix", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {908, 925}, m = "getUrl$suspendImpl", n = {"$this", "finallink", "quality", "subtitleCallback", "callback", "token", "$this", "finallink", "quality", "subtitleCallback", "callback", "token", "downloadlink", "finaldownloadlink", "link"}, nl = {920, 924}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00461 extends ContinuationImpl {
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

        C00461(Continuation<? super C00461> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Modflix.getUrl$suspendImpl(Modflix.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:20:0x01b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Modflix $this, String finallink, String quality, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00461 c00461;
        String token;
        Object obj;
        int i;
        Object objPost$default;
        Modflix $this2;
        String finallink2;
        String quality2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object objNewExtractorLink$default;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C00461) {
            c00461 = (C00461) continuation;
            if ((c00461.label & Integer.MIN_VALUE) != 0) {
                c00461.label -= Integer.MIN_VALUE;
            } else {
                c00461 = $this.new C00461(continuation);
            }
        } else {
            c00461 = $this.new C00461(continuation);
        }
        C00461 c00462 = c00461;
        Object $result = c00462.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00462.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String token2 = StringsKt.substringAfter$default(finallink, "https://video-seed.xyz/?url=", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("keys", token2));
                Map mapMapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("x-token", "video-seed.xyz"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0")});
                c00462.L$0 = $this;
                c00462.L$1 = SpillingKt.nullOutSpilledVariable(finallink);
                c00462.L$2 = quality;
                c00462.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00462.L$4 = function2;
                c00462.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                c00462.label = 1;
                token = token2;
                obj = coroutine_suspended;
                i = 2;
                objPost$default = Requests.post$default(app, "https://video-seed.xyz/api", mapMapOf2, finallink, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00462, 65496, (Object) null);
                c00462 = c00462;
                if (objPost$default == obj) {
                    return obj;
                }
                $this2 = $this;
                finallink2 = finallink;
                quality2 = quality;
                function3 = function1;
                function4 = function2;
                NiceResponse downloadlink = (NiceResponse) objPost$default;
                String finaldownloadlink = StringsKt.replace$default(StringsKt.substringBefore$default(StringsKt.substringAfter$default(downloadlink.toString(), "url\":\"", (String) r6, i, (Object) r6), "\",\"name", (String) r6, i, (Object) r6), "\\/", "/", false, 4, (Object) null);
                String name = $this2.getName();
                String name2 = $this2.getName();
                C00472 c00472 = new C00472(quality2, 0);
                c00462.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00462.L$1 = SpillingKt.nullOutSpilledVariable(finallink2);
                c00462.L$2 = SpillingKt.nullOutSpilledVariable(quality2);
                c00462.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00462.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00462.L$5 = SpillingKt.nullOutSpilledVariable(token);
                c00462.L$6 = SpillingKt.nullOutSpilledVariable(downloadlink);
                c00462.L$7 = SpillingKt.nullOutSpilledVariable(finaldownloadlink);
                c00462.L$8 = SpillingKt.nullOutSpilledVariable(finaldownloadlink);
                c00462.L$9 = function4;
                c00462.label = i;
                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(name, name2, finaldownloadlink, (ExtractorLinkType) null, c00472, c00462, 8, (Object) null);
                if (objNewExtractorLink$default == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke(objNewExtractorLink$default);
                return Unit.INSTANCE;
            case 1:
                String token3 = (String) c00462.L$5;
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00462.L$4;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c00462.L$3;
                String quality3 = (String) c00462.L$2;
                String finallink3 = (String) c00462.L$1;
                Modflix $this3 = (Modflix) c00462.L$0;
                ResultKt.throwOnFailure($result);
                token = token3;
                function4 = function6;
                function3 = function7;
                quality2 = quality3;
                finallink2 = finallink3;
                i = 2;
                $this2 = $this3;
                obj = coroutine_suspended;
                objPost$default = $result;
                NiceResponse downloadlink2 = (NiceResponse) objPost$default;
                String finaldownloadlink2 = StringsKt.replace$default(StringsKt.substringBefore$default(StringsKt.substringAfter$default(downloadlink2.toString(), "url\":\"", (String) r6, i, (Object) r6), "\",\"name", (String) r6, i, (Object) r6), "\\/", "/", false, 4, (Object) null);
                String name3 = $this2.getName();
                String name4 = $this2.getName();
                C00472 c00473 = new C00472(quality2, 0);
                c00462.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00462.L$1 = SpillingKt.nullOutSpilledVariable(finallink2);
                c00462.L$2 = SpillingKt.nullOutSpilledVariable(quality2);
                c00462.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00462.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00462.L$5 = SpillingKt.nullOutSpilledVariable(token);
                c00462.L$6 = SpillingKt.nullOutSpilledVariable(downloadlink2);
                c00462.L$7 = SpillingKt.nullOutSpilledVariable(finaldownloadlink2);
                c00462.L$8 = SpillingKt.nullOutSpilledVariable(finaldownloadlink2);
                c00462.L$9 = function4;
                c00462.label = i;
                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(name3, name4, finaldownloadlink2, (ExtractorLinkType) null, c00473, c00462, 8, (Object) null);
                if (objNewExtractorLink$default == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke(objNewExtractorLink$default);
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c00462.L$9;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink$default = $result;
                function5.invoke(objNewExtractorLink$default);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Modflix$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Modflix$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00472 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00472(String str, Continuation<? super C00472> continuation) {
            super(2, continuation);
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00472 = new C00472(this.$quality, continuation);
            c00472.L$0 = obj;
            return c00472;
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
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$quality));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
