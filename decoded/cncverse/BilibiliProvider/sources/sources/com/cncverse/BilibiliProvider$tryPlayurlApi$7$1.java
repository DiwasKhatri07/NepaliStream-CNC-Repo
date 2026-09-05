package com.cncverse;

import com.lagradost.cloudstream3.AudioFile;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BilibiliProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/BilibiliProvider/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AudioFile;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.BilibiliProvider$tryPlayurlApi$7$1", f = "BilibiliProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class BilibiliProvider$tryPlayurlApi$7$1 extends SuspendLambda implements Function2<AudioFile, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $streamHeaders;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BilibiliProvider$tryPlayurlApi$7$1(Map<String, String> map, Continuation<? super BilibiliProvider$tryPlayurlApi$7$1> continuation) {
        super(2, continuation);
        this.$streamHeaders = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> bilibiliProvider$tryPlayurlApi$7$1 = new BilibiliProvider$tryPlayurlApi$7$1(this.$streamHeaders, continuation);
        bilibiliProvider$tryPlayurlApi$7$1.L$0 = obj;
        return bilibiliProvider$tryPlayurlApi$7$1;
    }

    public final Object invoke(AudioFile audioFile, Continuation<? super Unit> continuation) {
        return create(audioFile, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AudioFile $this$newAudioFile = (AudioFile) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newAudioFile.setHeaders(this.$streamHeaders);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
