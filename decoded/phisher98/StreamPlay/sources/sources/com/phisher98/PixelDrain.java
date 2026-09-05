package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.List;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/PixelDrain;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class PixelDrain extends ExtractorApi {

    @NotNull
    private final String name = "PixelDrain";

    @NotNull
    private final String mainUrl = "https://pixeldrain.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.PixelDrain$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PixelDrain", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {978, 989}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "mId", "$this", "url", "referer", "subtitleCallback", "callback", "mId"}, nl = {977, 988}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00531(Continuation<? super C00531> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PixelDrain.getUrl$suspendImpl(PixelDrain.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    static /* synthetic */ Object getUrl$suspendImpl(PixelDrain $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00531 c00531;
        PixelDrain pixelDrain;
        String mId;
        Object obj;
        Function1<? super ExtractorLink, Unit> function3;
        List groupValues;
        Function1<? super ExtractorLink, Unit> function4 = function2;
        if (continuation instanceof C00531) {
            c00531 = (C00531) continuation;
            if ((c00531.label & Integer.MIN_VALUE) != 0) {
                c00531.label -= Integer.MIN_VALUE;
                pixelDrain = $this;
            } else {
                pixelDrain = $this;
                c00531 = pixelDrain.new C00531(continuation);
            }
        } else {
            pixelDrain = $this;
            c00531 = pixelDrain.new C00531(continuation);
        }
        C00531 c00532 = c00531;
        Object $result = c00532.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00532.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MatchResult matchResultFind$default = Regex.find$default(new Regex("/u/(.*)"), url, 0, 2, (Object) null);
                String mId2 = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : (String) groupValues.get(1);
                String str = mId2;
                if (str == null || str.length() == 0) {
                    String name = pixelDrain.getName();
                    String name2 = pixelDrain.getName();
                    C00542 c00542 = new C00542(url, null);
                    c00532.L$0 = SpillingKt.nullOutSpilledVariable(pixelDrain);
                    c00532.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00532.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                    c00532.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    c00532.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                    c00532.L$5 = SpillingKt.nullOutSpilledVariable(mId2);
                    c00532.L$6 = function4;
                    c00532.label = 1;
                    Object objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(name, name2, url, (ExtractorLinkType) null, c00542, c00532, 8, (Object) null);
                    if (objNewExtractorLink$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objNewExtractorLink$default;
                    function3 = function4;
                    function3.invoke(obj);
                    return Unit.INSTANCE;
                }
                String name3 = pixelDrain.getName();
                String name4 = pixelDrain.getName();
                String mId3 = pixelDrain.getMainUrl() + "/api/file/" + mId2 + "?download";
                C00553 c00553 = new C00553(url, null);
                c00532.L$0 = SpillingKt.nullOutSpilledVariable(pixelDrain);
                c00532.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00532.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00532.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00532.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00532.L$5 = SpillingKt.nullOutSpilledVariable(mId2);
                c00532.L$6 = function4;
                c00532.label = 2;
                $result = ExtractorApiKt.newExtractorLink$default(name3, name4, mId3, (ExtractorLinkType) null, c00553, c00532, 8, (Object) null);
                if ($result != coroutine_suspended) {
                    mId = mId2;
                    function4.invoke($result);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            case 1:
                function3 = (Function1) c00532.L$6;
                ResultKt.throwOnFailure($result);
                obj = $result;
                function3.invoke(obj);
                return Unit.INSTANCE;
            case 2:
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00532.L$6;
                mId = (String) c00532.L$5;
                ResultKt.throwOnFailure($result);
                function4 = function5;
                function4.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.PixelDrain$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PixelDrain$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00542 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00542(String str, Continuation<? super C00542> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00542 = new C00542(this.$url, continuation);
            c00542.L$0 = obj;
            return c00542;
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

    /* JADX INFO: renamed from: com.phisher98.PixelDrain$getUrl$3 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.PixelDrain$getUrl$3", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00553 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00553(String str, Continuation<? super C00553> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00553 = new C00553(this.$url, continuation);
            c00553.L$0 = obj;
            return c00553;
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
