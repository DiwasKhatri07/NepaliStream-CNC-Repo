package com.phisher98;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.ExtractorKt$bypassXD$resultUrl$1", f = "Extractor.kt", i = {}, l = {515}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
final class ExtractorKt$bypassXD$resultUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $baseUrl;
    final /* synthetic */ String $fingerprint;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExtractorKt$bypassXD$resultUrl$1(String str, String str2, String str3, Continuation<? super ExtractorKt$bypassXD$resultUrl$1> continuation) {
        super(2, continuation);
        this.$baseUrl = str;
        this.$sessionId = str2;
        this.$fingerprint = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtractorKt$bypassXD$resultUrl$1(this.$baseUrl, this.$sessionId, this.$fingerprint, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object objShowXDSessionDialogAndWait = XDMoviesKt.showXDSessionDialogAndWait(this.$baseUrl, this.$sessionId, this.$fingerprint, (Continuation) this);
                if (objShowXDSessionDialogAndWait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objShowXDSessionDialogAndWait;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
