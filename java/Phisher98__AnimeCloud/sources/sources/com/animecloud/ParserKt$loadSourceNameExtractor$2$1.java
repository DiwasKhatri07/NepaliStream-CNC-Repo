package com.animecloud;

import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
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

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeCloud/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.animecloud.ParserKt$loadSourceNameExtractor$2$1", f = "Parser.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, nl = {167}, s = {}, v = 2)
final class ParserKt$loadSourceNameExtractor$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ ExtractorLink $link;
    final /* synthetic */ String $quality;
    final /* synthetic */ String $source;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ParserKt$loadSourceNameExtractor$2$1(Function1<? super ExtractorLink, Unit> function1, String str, ExtractorLink extractorLink, String str2, Continuation<? super ParserKt$loadSourceNameExtractor$2$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$source = str;
        this.$link = extractorLink;
        this.$quality = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ParserKt$loadSourceNameExtractor$2$1(this.$callback, this.$source, this.$link, this.$quality, continuation);
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
                this.L$0 = function2;
                this.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(this.$source, this.$source, this.$link.getUrl(), this.$link.getType(), new C00101(this.$link, this.$quality, null), (Continuation) this);
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

    /* JADX INFO: renamed from: com.animecloud.ParserKt$loadSourceNameExtractor$2$1$1 */
    /* JADX INFO: compiled from: Parser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.ParserKt$loadSourceNameExtractor$2$1$1", f = "Parser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00101 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtractorLink $link;
        final /* synthetic */ String $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00101(ExtractorLink extractorLink, String str, Continuation<? super C00101> continuation) {
            super(2, continuation);
            this.$link = extractorLink;
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00101 = new C00101(this.$link, this.$quality, continuation);
            c00101.L$0 = obj;
            return c00101;
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
                    $this$newExtractorLink.setReferer(this.$link.getReferer());
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$quality));
                    $this$newExtractorLink.setHeaders(this.$link.getHeaders());
                    $this$newExtractorLink.setExtractorData(this.$link.getExtractorData());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
