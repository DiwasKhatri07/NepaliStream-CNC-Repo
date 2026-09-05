package com.Animeav1;

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

/* JADX INFO: compiled from: Animeav1.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Animeav1/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Animeav1.Animeav1Kt$loadCustomExtractor$2$1", f = "Animeav1.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, nl = {220}, s = {}, v = 2)
final class Animeav1Kt$loadCustomExtractor$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ ExtractorLink $link;
    final /* synthetic */ String $name;
    final /* synthetic */ Integer $quality;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Animeav1Kt$loadCustomExtractor$2$1(Function1<? super ExtractorLink, Unit> function1, String str, ExtractorLink extractorLink, Integer num, Continuation<? super Animeav1Kt$loadCustomExtractor$2$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$name = str;
        this.$link = extractorLink;
        this.$quality = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Animeav1Kt$loadCustomExtractor$2$1(this.$callback, this.$name, this.$link, this.$quality, continuation);
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
                String source = this.$name;
                if (source == null) {
                    source = this.$link.getSource();
                }
                String str = source;
                String name = this.$name;
                if (name == null) {
                    name = this.$link.getName();
                }
                this.L$0 = function2;
                this.label = 1;
                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(str, name, this.$link.getUrl(), (ExtractorLinkType) null, new C00091(this.$quality, this.$link, null), (Continuation) this, 8, (Object) null);
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

    /* JADX INFO: renamed from: com.Animeav1.Animeav1Kt$loadCustomExtractor$2$1$1 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1Kt$loadCustomExtractor$2$1$1", f = "Animeav1.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00091 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtractorLink $link;
        final /* synthetic */ Integer $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00091(Integer num, ExtractorLink extractorLink, Continuation<? super C00091> continuation) {
            super(2, continuation);
            this.$quality = num;
            this.$link = extractorLink;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00091 = new C00091(this.$quality, this.$link, continuation);
            c00091.L$0 = obj;
            return c00091;
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
