package com.phisher98;

import com.lagradost.cloudstream3.TvType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$load$2$logoDeferred$1", f = "StreamPlay.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, nl = {398}, s = {}, v = 2)
final class StreamPlay$load$2$logoDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Deferred<StreamPlay.MediaDetail> $resDeferred;
    final /* synthetic */ String $tmdbAPI;
    final /* synthetic */ TvType $type;
    int label;
    final /* synthetic */ StreamPlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$load$2$logoDeferred$1(Deferred<StreamPlay.MediaDetail> deferred, String str, TvType tvType, StreamPlay streamPlay, Continuation<? super StreamPlay$load$2$logoDeferred$1> continuation) {
        super(2, continuation);
        this.$resDeferred = deferred;
        this.$tmdbAPI = str;
        this.$type = tvType;
        this.this$0 = streamPlay;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlay$load$2$logoDeferred$1(this.$resDeferred, this.$tmdbAPI, this.$type, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlay$load$2$logoDeferred$1$1 */
    /* JADX INFO: compiled from: StreamPlay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlay$load$2$logoDeferred$1$1", f = "StreamPlay.kt", i = {1}, l = {390, 391}, m = "invokeSuspend", n = {"tempRes"}, nl = {391, 397}, s = {"L$0"}, v = 2)
    static final class C00691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Deferred<StreamPlay.MediaDetail> $resDeferred;
        final /* synthetic */ String $tmdbAPI;
        final /* synthetic */ TvType $type;
        Object L$0;
        int label;
        final /* synthetic */ StreamPlay this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00691(Deferred<StreamPlay.MediaDetail> deferred, String str, TvType tvType, StreamPlay streamPlay, Continuation<? super C00691> continuation) {
            super(2, continuation);
            this.$resDeferred = deferred;
            this.$tmdbAPI = str;
            this.$type = tvType;
            this.this$0 = streamPlay;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00691(this.$resDeferred, this.$tmdbAPI, this.$type, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objAwait;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objAwait = this.$resDeferred.await((Continuation) this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objAwait = $result;
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            StreamPlay.MediaDetail tempRes = (StreamPlay.MediaDetail) objAwait;
            String str = this.$tmdbAPI;
            TvType tvType = this.$type;
            Integer id = tempRes != null ? tempRes.getId() : null;
            String langCode = this.this$0.getLangCode();
            if (langCode == null) {
                langCode = "en";
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(tempRes);
            this.label = 2;
            Object objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl(str, "98ae14df2b8d8f8f8136499daf79f0e0", tvType, id, langCode, (Continuation) this);
            if (objFetchTmdbLogoUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
            return objFetchTmdbLogoUrl;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Duration.Companion companion = Duration.Companion;
                this.label = 1;
                Object obj = TimeoutKt.withTimeoutOrNull-KLykuaI(DurationKt.toDuration(10000, DurationUnit.MILLISECONDS), new C00691(this.$resDeferred, this.$tmdbAPI, this.$type, this.this$0, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
