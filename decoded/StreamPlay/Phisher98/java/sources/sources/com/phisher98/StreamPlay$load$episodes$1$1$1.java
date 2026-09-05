package com.phisher98;

import com.lagradost.cloudstream3.Episode;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$load$episodes$1$1$1", f = "StreamPlay.kt", i = {0, 1}, l = {930, 464}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv"}, nl = {931, 513}, s = {"L$0", "L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$episodes$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,929:1\n81#2,6:930\n*S KotlinDebug\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$load$episodes$1$1$1\n*L\n463#1:930,6\n*E\n"})
final class StreamPlay$load$episodes$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Episode>>, Object> {
    final /* synthetic */ StreamPlay.Data $data;
    final /* synthetic */ String $enTitle;
    final /* synthetic */ boolean $isAnime;
    final /* synthetic */ boolean $isAsian;
    final /* synthetic */ boolean $isBollywood;
    final /* synthetic */ boolean $isCartoon;
    final /* synthetic */ Integer $lastSeason;
    final /* synthetic */ String $orgTitle;
    final /* synthetic */ Ref.ObjectRef<StreamPlay.MediaDetail> $res;
    final /* synthetic */ StreamPlay.Seasons $season;
    final /* synthetic */ Semaphore $semaphore;
    final /* synthetic */ String $tmdbAPI;
    final /* synthetic */ Integer $year;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    int label;
    final /* synthetic */ StreamPlay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$load$episodes$1$1$1(Semaphore semaphore, String str, StreamPlay.Data data, StreamPlay.Seasons seasons, StreamPlay streamPlay, Ref.ObjectRef<StreamPlay.MediaDetail> objectRef, String str2, String str3, boolean z, Integer num, Integer num2, boolean z2, boolean z3, boolean z4, Continuation<? super StreamPlay$load$episodes$1$1$1> continuation) {
        super(2, continuation);
        this.$semaphore = semaphore;
        this.$tmdbAPI = str;
        this.$data = data;
        this.$season = seasons;
        this.this$0 = streamPlay;
        this.$res = objectRef;
        this.$enTitle = str2;
        this.$orgTitle = str3;
        this.$isAnime = z;
        this.$year = num;
        this.$lastSeason = num2;
        this.$isAsian = z2;
        this.$isBollywood = z3;
        this.$isCartoon = z4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlay$load$episodes$1$1$1(this.$semaphore, this.$tmdbAPI, this.$data, this.$season, this.this$0, this.$res, this.$enTitle, this.$orgTitle, this.$isAnime, this.$year, this.$lastSeason, this.$isAsian, this.$isBollywood, this.$isCartoon, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Episode>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:20:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:23:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0123  */
    public final Object invokeSuspend(Object $result) throws Throwable {
        Object obj;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Integer num;
        Integer num2;
        String str2;
        String str3;
        Ref.ObjectRef<StreamPlay.MediaDetail> objectRef;
        StreamPlay streamPlay;
        StreamPlay.Seasons seasons;
        Semaphore $this$withPermit$iv;
        StreamPlay.Data data;
        Semaphore $this$withPermit$iv2;
        boolean z5;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore $this$withPermit$iv3 = this.$semaphore;
                String str4 = this.$tmdbAPI;
                StreamPlay.Data data2 = this.$data;
                StreamPlay.Seasons seasons2 = this.$season;
                StreamPlay streamPlay2 = this.this$0;
                Ref.ObjectRef<StreamPlay.MediaDetail> objectRef2 = this.$res;
                String str5 = this.$enTitle;
                String str6 = this.$orgTitle;
                boolean z6 = this.$isAnime;
                Integer num3 = this.$year;
                Integer num4 = this.$lastSeason;
                boolean z7 = this.$isAsian;
                boolean z8 = this.$isBollywood;
                boolean z9 = this.$isCartoon;
                this.L$0 = $this$withPermit$iv3;
                this.L$1 = str4;
                this.L$2 = data2;
                this.L$3 = seasons2;
                this.L$4 = streamPlay2;
                this.L$5 = objectRef2;
                this.L$6 = str5;
                this.L$7 = str6;
                this.L$8 = num3;
                this.L$9 = num4;
                this.Z$0 = z6;
                this.Z$1 = z7;
                this.Z$2 = z8;
                this.Z$3 = z9;
                this.label = 1;
                obj = coroutine_suspended;
                if ($this$withPermit$iv3.acquire((Continuation) this) == obj) {
                    return obj;
                }
                str = str4;
                z = z9;
                z2 = z8;
                z3 = z7;
                z4 = z6;
                num = num4;
                num2 = num3;
                str2 = str6;
                str3 = str5;
                objectRef = objectRef2;
                streamPlay = streamPlay2;
                seasons = seasons2;
                $this$withPermit$iv = $this$withPermit$iv3;
                data = data2;
                try {
                    Duration.Companion companion = Duration.Companion;
                    long duration = DurationKt.toDuration(5000, DurationUnit.MILLISECONDS);
                    if (z) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    StreamPlay$load$episodes$1$1$1$1$1 streamPlay$load$episodes$1$1$1$1$1 = new StreamPlay$load$episodes$1$1$1$1$1(str, data, seasons, streamPlay, objectRef, str3, str2, z4, num2, num, z3, z2, z5, null);
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.L$7 = null;
                    this.L$8 = null;
                    this.L$9 = null;
                    this.label = 2;
                    obj2 = TimeoutKt.withTimeoutOrNull-KLykuaI(duration, streamPlay$load$episodes$1$1$1$1$1, this);
                    if (obj2 == obj) {
                        return obj;
                    }
                    $this$withPermit$iv2 = $this$withPermit$iv;
                    List list = (List) obj2;
                    $this$withPermit$iv2.release();
                    return list;
                } catch (Throwable th) {
                    th = th;
                    $this$withPermit$iv2 = $this$withPermit$iv;
                    $this$withPermit$iv2.release();
                    throw th;
                }
            case 1:
                boolean z10 = this.Z$3;
                boolean z11 = this.Z$2;
                boolean z12 = this.Z$1;
                boolean z13 = this.Z$0;
                Integer num5 = (Integer) this.L$9;
                Integer num6 = (Integer) this.L$8;
                String str7 = (String) this.L$7;
                String str8 = (String) this.L$6;
                Ref.ObjectRef<StreamPlay.MediaDetail> objectRef3 = (Ref.ObjectRef) this.L$5;
                StreamPlay streamPlay3 = (StreamPlay) this.L$4;
                StreamPlay.Seasons seasons3 = (StreamPlay.Seasons) this.L$3;
                StreamPlay.Data data3 = (StreamPlay.Data) this.L$2;
                String str9 = (String) this.L$1;
                Semaphore $this$withPermit$iv4 = (Semaphore) this.L$0;
                ResultKt.throwOnFailure($result);
                str = str9;
                obj = coroutine_suspended;
                z2 = z11;
                z3 = z12;
                z4 = z13;
                num = num5;
                num2 = num6;
                str2 = str7;
                str3 = str8;
                objectRef = objectRef3;
                streamPlay = streamPlay3;
                seasons = seasons3;
                data = data3;
                z = z10;
                $this$withPermit$iv = $this$withPermit$iv4;
                Duration.Companion companion2 = Duration.Companion;
                long duration2 = DurationKt.toDuration(5000, DurationUnit.MILLISECONDS);
                if (z) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                StreamPlay$load$episodes$1$1$1$1$1 streamPlay$load$episodes$1$1$1$1$2 = new StreamPlay$load$episodes$1$1$1$1$1(str, data, seasons, streamPlay, objectRef, str3, str2, z4, num2, num, z3, z2, z5, null);
                this.L$0 = $this$withPermit$iv;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.L$8 = null;
                this.L$9 = null;
                this.label = 2;
                obj2 = TimeoutKt.withTimeoutOrNull-KLykuaI(duration2, streamPlay$load$episodes$1$1$1$1$2, this);
                if (obj2 == obj) {
                    return obj;
                }
                $this$withPermit$iv2 = $this$withPermit$iv;
                List list2 = (List) obj2;
                $this$withPermit$iv2.release();
                return list2;
            case 2:
                $this$withPermit$iv2 = (Semaphore) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj2 = $result;
                    List list3 = (List) obj2;
                    $this$withPermit$iv2.release();
                    return list3;
                } catch (Throwable th2) {
                    th = th2;
                    $this$withPermit$iv2.release();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
