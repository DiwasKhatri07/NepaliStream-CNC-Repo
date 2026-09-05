package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$invokeExternalSource$2$2$1$1", f = "StreamPlayUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class StreamPlayUtilsKt$invokeExternalSource$2$2$1$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExternalResponse.Data.FileList $fileList;
    final /* synthetic */ ExtractorLinkType $format;
    final /* synthetic */ ExternalSources $source;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayUtilsKt$invokeExternalSource$2$2$1$1(ExtractorLinkType extractorLinkType, ExternalResponse.Data.FileList fileList, ExternalSources externalSources, Continuation<? super StreamPlayUtilsKt$invokeExternalSource$2$2$1$1> continuation) {
        super(2, continuation);
        this.$format = extractorLinkType;
        this.$fileList = fileList;
        this.$source = externalSources;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayUtilsKt$invokeExternalSource$2$2$1$1 = new StreamPlayUtilsKt$invokeExternalSource$2$2$1$1(this.$format, this.$fileList, this.$source, continuation);
        streamPlayUtilsKt$invokeExternalSource$2$2$1$1.L$0 = obj;
        return streamPlayUtilsKt$invokeExternalSource$2$2$1$1;
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
                $this$newExtractorLink.setQuality(StreamPlayUtilsKt.getIndexQuality(this.$format == ExtractorLinkType.M3U8 ? this.$fileList.getFileName() : this.$source.getLabel()));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
