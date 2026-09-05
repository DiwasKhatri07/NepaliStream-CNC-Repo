package com.Tamilian;

import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Tamilian.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/Tamilian/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.Tamilian.Tamilian$loadLinks$3$1", f = "Tamilian.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, nl = {92}, s = {}, v = 2)
final class Tamilian$loadLinks$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ Tamilian.VideoData $it;
    Object L$0;
    int label;
    final /* synthetic */ Tamilian this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Tamilian$loadLinks$3$1(Function1<? super ExtractorLink, Unit> function1, Tamilian tamilian, Tamilian.VideoData videoData, Map<String, String> map, Continuation<? super Tamilian$loadLinks$3$1> continuation) {
        super(1, continuation);
        this.$callback = function1;
        this.this$0 = tamilian;
        this.$it = videoData;
        this.$headers = map;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Tamilian$loadLinks$3$1(this.$callback, this.this$0, this.$it, this.$headers, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objNewExtractorLink;
        Function1<ExtractorLink, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<ExtractorLink, Unit> function2 = this.$callback;
                this.L$0 = function2;
                this.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(this.this$0.getName(), this.this$0.getName(), this.$it.getVideoSource(), ExtractorLinkType.M3U8, new C00011(this.this$0, this.$headers, null), (Continuation) this);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function1 = function2;
                break;
                break;
            case 1:
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1.invoke(objNewExtractorLink);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Tamilian.Tamilian$loadLinks$3$1$1 */
    /* JADX INFO: compiled from: Tamilian.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.Tamilian.Tamilian$loadLinks$3$1$1", f = "Tamilian.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00011 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Tamilian this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00011(Tamilian tamilian, Map<String, String> map, Continuation<? super C00011> continuation) {
            super(2, continuation);
            this.this$0 = tamilian;
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00011 = new C00011(this.this$0, this.$headers, continuation);
            c00011.L$0 = obj;
            return c00011;
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
                    $this$newExtractorLink.setReferer(this.this$0.getMainUrl() + '/');
                    $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                    $this$newExtractorLink.setHeaders(this.$headers);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
