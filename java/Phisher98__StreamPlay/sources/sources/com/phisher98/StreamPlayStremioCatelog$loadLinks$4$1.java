package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: StreamPlayStremioCatelog.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayStremioCatelog$loadLinks$4$1", f = "StreamPlayStremioCatelog.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, nl = {174}, s = {}, v = 2)
final class StreamPlayStremioCatelog$loadLinks$4$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $authToken;
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Provider $provider;
    final /* synthetic */ StreamPlayStremioCatelog.LoadData $resolved;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    int label;
    final /* synthetic */ StreamPlayStremioCatelog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayStremioCatelog$loadLinks$4$1(Provider provider, StreamPlayStremioCatelog streamPlayStremioCatelog, StreamPlayStremioCatelog.LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super StreamPlayStremioCatelog$loadLinks$4$1> continuation) {
        super(1, continuation);
        this.$provider = provider;
        this.this$0 = streamPlayStremioCatelog;
        this.$resolved = loadData;
        this.$subtitleCallback = function1;
        this.$callback = function2;
        this.$authToken = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlayStremioCatelog$loadLinks$4$1(this.$provider, this.this$0, this.$resolved, this.$subtitleCallback, this.$callback, this.$authToken, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Function6<StreamPlay.LinkData, Function1<? super SubtitleFile, Unit>, Function1<? super ExtractorLink, Unit>, String, String, Continuation<? super Unit>, Object> invoke = this.$provider.getInvoke();
                    StreamPlay.LinkData linkData = this.this$0.toLinkData(this.$resolved);
                    Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    String str = this.$authToken;
                    if (str == null) {
                        str = "";
                    }
                    this.label = 1;
                    if (invoke.invoke(linkData, function1, function2, str, StreamPlay.dahmerMoviesAPI, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
        }
        return Unit.INSTANCE;
    }
}
