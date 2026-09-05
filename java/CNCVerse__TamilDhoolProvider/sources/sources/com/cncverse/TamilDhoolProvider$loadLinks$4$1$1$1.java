package com.cncverse;

import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TamilDhoolProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/TamilDhoolProvider/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.TamilDhoolProvider$loadLinks$4$1$1$1", f = "TamilDhoolProvider.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, nl = {239}, s = {}, v = 2)
final class TamilDhoolProvider$loadLinks$4$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $displayName;
    final /* synthetic */ ExtractorLink $extractedLink;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TamilDhoolProvider$loadLinks$4$1$1$1(Function1<? super ExtractorLink, Unit> function1, ExtractorLink extractorLink, String str, Continuation<? super TamilDhoolProvider$loadLinks$4$1$1$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$extractedLink = extractorLink;
        this.$displayName = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TamilDhoolProvider$loadLinks$4$1$1$1(this.$callback, this.$extractedLink, this.$displayName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objNewExtractorLink;
        Function1<ExtractorLink, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<ExtractorLink, Unit> function2 = this.$callback;
                String source = this.$extractedLink.getSource();
                String str = this.$displayName;
                String url = this.$extractedLink.getUrl();
                ExtractorLinkType extractorLinkType = this.$extractedLink.isM3u8() ? ExtractorLinkType.M3U8 : ExtractorLinkType.VIDEO;
                this.L$0 = function2;
                this.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(source, str, url, extractorLinkType, new C00061(this.$extractedLink, null), (Continuation) this);
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

    /* JADX INFO: renamed from: com.cncverse.TamilDhoolProvider$loadLinks$4$1$1$1$1 */
    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilDhoolProvider$loadLinks$4$1$1$1$1", f = "TamilDhoolProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00061 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtractorLink $extractedLink;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00061(ExtractorLink extractorLink, Continuation<? super C00061> continuation) {
            super(2, continuation);
            this.$extractedLink = extractorLink;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00061 = new C00061(this.$extractedLink, continuation);
            c00061.L$0 = obj;
            return c00061;
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
                    $this$newExtractorLink.setReferer(this.$extractedLink.getReferer());
                    $this$newExtractorLink.setQuality(this.$extractedLink.getQuality());
                    $this$newExtractorLink.setHeaders(this.$extractedLink.getHeaders());
                    $this$newExtractorLink.setExtractorData(this.$extractedLink.getExtractorData());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
