package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/CinemetaRes;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$load$2$cineDeferred$1", f = "StreamPlay.kt", i = {1}, l = {402, 404}, m = "invokeSuspend", n = {"tempRes"}, nl = {403, 411}, s = {"L$0"}, v = 2)
final class StreamPlay$load$2$cineDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CinemetaRes>, Object> {
    final /* synthetic */ Deferred<StreamPlay.MediaDetail> $resDeferred;
    final /* synthetic */ TvType $type;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$load$2$cineDeferred$1(Deferred<StreamPlay.MediaDetail> deferred, TvType tvType, Continuation<? super StreamPlay$load$2$cineDeferred$1> continuation) {
        super(2, continuation);
        this.$resDeferred = deferred;
        this.$type = tvType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlay$load$2$cineDeferred$1(this.$resDeferred, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CinemetaRes> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    /* JADX WARN: Code duplicated, block: B:20:0x0069 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x006a  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public final Object invokeSuspend(Object $result) {
        Object objAwait;
        StreamPlay.MediaDetail tempRes;
        String imdb_id;
        Object obj;
        StreamPlay.MediaDetail tempRes2;
        StreamPlay.ExternalIds external_ids;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                objAwait = this.$resDeferred.await((Continuation) this);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                tempRes = (StreamPlay.MediaDetail) objAwait;
                if (tempRes != null || (external_ids = tempRes.getExternal_ids()) == null) {
                    imdb_id = null;
                } else {
                    imdb_id = external_ids.getImdb_id();
                }
                if (imdb_id != null) {
                    return null;
                }
                Duration.Companion companion = Duration.Companion;
                this.L$0 = SpillingKt.nullOutSpilledVariable(tempRes);
                this.label = 2;
                obj = TimeoutKt.withTimeoutOrNull-KLykuaI(DurationKt.toDuration(10000, DurationUnit.MILLISECONDS), new C00671(this.$type, tempRes, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                tempRes2 = tempRes;
                return (CinemetaRes) obj;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwait = $result;
                tempRes = (StreamPlay.MediaDetail) objAwait;
                if (tempRes != null) {
                    imdb_id = null;
                } else {
                    imdb_id = null;
                }
                if (imdb_id != null) {
                    return null;
                }
                Duration.Companion companion2 = Duration.Companion;
                this.L$0 = SpillingKt.nullOutSpilledVariable(tempRes);
                this.label = 2;
                obj = TimeoutKt.withTimeoutOrNull-KLykuaI(DurationKt.toDuration(10000, DurationUnit.MILLISECONDS), new C00671(this.$type, tempRes, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                tempRes2 = tempRes;
                return (CinemetaRes) obj;
            case 2:
                tempRes2 = (StreamPlay.MediaDetail) this.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                return (CinemetaRes) obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlay$load$2$cineDeferred$1$1 */
    /* JADX INFO: compiled from: StreamPlay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/phisher98/CinemetaRes;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlay$load$2$cineDeferred$1$1", f = "StreamPlay.kt", i = {0}, l = {406}, m = "invokeSuspend", n = {"cinetype"}, nl = {409}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$2$cineDeferred$1$1\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,929:1\n73#2,5:930\n*S KotlinDebug\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$2$cineDeferred$1$1\n*L\n409#1:930,5\n*E\n"})
    static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CinemetaRes>, Object> {
        final /* synthetic */ StreamPlay.MediaDetail $tempRes;
        final /* synthetic */ TvType $type;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00671(TvType tvType, StreamPlay.MediaDetail mediaDetail, Continuation<? super C00671> continuation) {
            super(2, continuation);
            this.$type = tvType;
            this.$tempRes = mediaDetail;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00671(this.$type, this.$tempRes, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CinemetaRes> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String cinetype = this.$type == TvType.TvSeries ? "series" : "movie";
                    this.L$0 = SpillingKt.nullOutSpilledVariable(cinetype);
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + cinetype + '/' + this.$tempRes.getExternal_ids().getImdb_id() + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4030, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse this_$iv = (NiceResponse) obj;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                return parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                return null;
            }
        }
    }
}
