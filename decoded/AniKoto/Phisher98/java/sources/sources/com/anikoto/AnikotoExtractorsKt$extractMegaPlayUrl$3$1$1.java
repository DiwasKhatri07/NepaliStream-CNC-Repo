package com.anikoto;

import com.lagradost.cloudstream3.SubtitleFile;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AnikotoExtractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniKoto/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SubtitleFile;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.anikoto.AnikotoExtractorsKt$extractMegaPlayUrl$3$1$1", f = "AnikotoExtractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class AnikotoExtractorsKt$extractMegaPlayUrl$3$1$1 extends SuspendLambda implements Function2<SubtitleFile, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $playbackHeaders;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnikotoExtractorsKt$extractMegaPlayUrl$3$1$1(Map<String, String> map, Continuation<? super AnikotoExtractorsKt$extractMegaPlayUrl$3$1$1> continuation) {
        super(2, continuation);
        this.$playbackHeaders = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> anikotoExtractorsKt$extractMegaPlayUrl$3$1$1 = new AnikotoExtractorsKt$extractMegaPlayUrl$3$1$1(this.$playbackHeaders, continuation);
        anikotoExtractorsKt$extractMegaPlayUrl$3$1$1.L$0 = obj;
        return anikotoExtractorsKt$extractMegaPlayUrl$3$1$1;
    }

    public final Object invoke(SubtitleFile subtitleFile, Continuation<? super Unit> continuation) {
        return create(subtitleFile, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SubtitleFile $this$newSubtitleFile = (SubtitleFile) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newSubtitleFile.setHeaders(this.$playbackHeaders);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
