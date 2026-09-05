package com.Goojara;

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

/* JADX INFO: compiled from: Goojara.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Goojara/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Goojara.Goojara$loadSourceNameExtractor$2$1", f = "Goojara.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, nl = {347}, s = {}, v = 2)
final class Goojara$loadSourceNameExtractor$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ ExtractorLink $link;
    final /* synthetic */ Integer $quality;
    final /* synthetic */ String $source;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Goojara$loadSourceNameExtractor$2$1(Function1<? super ExtractorLink, Unit> function1, ExtractorLink extractorLink, String str, Integer num, Continuation<? super Goojara$loadSourceNameExtractor$2$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$link = extractorLink;
        this.$source = str;
        this.$quality = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Goojara$loadSourceNameExtractor$2$1(this.$callback, this.$link, this.$source, this.$quality, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objNewExtractorLink$default;
        Function1<ExtractorLink, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<ExtractorLink, Unit> function2 = this.$callback;
                this.L$0 = function2;
                this.label = 1;
                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(this.$link.getSource() + ' ' + this.$source, this.$link.getSource() + ' ' + this.$source, this.$link.getUrl(), (ExtractorLinkType) null, new C00071(this.$quality, this.$link, null), (Continuation) this, 8, (Object) null);
                if (objNewExtractorLink$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function1 = function2;
                break;
                break;
            case 1:
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1.invoke(objNewExtractorLink$default);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$loadSourceNameExtractor$2$1$1 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara$loadSourceNameExtractor$2$1$1", f = "Goojara.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00071 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtractorLink $link;
        final /* synthetic */ Integer $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00071(Integer num, ExtractorLink extractorLink, Continuation<? super C00071> continuation) {
            super(2, continuation);
            this.$quality = num;
            this.$link = extractorLink;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00071 = new C00071(this.$quality, this.$link, continuation);
            c00071.L$0 = obj;
            return c00071;
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
                    Integer num = this.$quality;
                    $this$newExtractorLink.setQuality(num != null ? num.intValue() : this.$link.getQuality());
                    $this$newExtractorLink.setType(this.$link.getType());
                    $this$newExtractorLink.setReferer(this.$link.getReferer());
                    $this$newExtractorLink.setHeaders(this.$link.getHeaders());
                    $this$newExtractorLink.setExtractorData(this.$link.getExtractorData());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
