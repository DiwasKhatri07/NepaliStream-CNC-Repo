package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: AllMovieLandProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AllMovieLandProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.AllMovieLandProvider$loadLinks$3$1", f = "AllMovieLandProvider.kt", i = {2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {355, 366, 380, 381, 383}, m = "invokeSuspend", n = {"payload", "playerDomain", "tokenKey", "headers", "files", "$this$forEach$iv", "element$iv", "file", "payload", "playerDomain", "tokenKey", "headers", "files", "$this$forEach$iv", "element$iv", "file", "m3u8", "payload", "playerDomain", "tokenKey", "headers", "files", "$this$forEach$iv", "element$iv", "file", "m3u8", "$this$forEach$iv", "element$iv", "link"}, nl = {354, 367, 381, 382, 392}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16"}, v = 2)
@SourceDebugExtension({"SMAP\nAllMovieLandProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider$loadLinks$3$1\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,578:1\n93#2,2:579\n63#2:581\n64#2,15:583\n95#2,2:600\n1#3:582\n50#4:598\n43#4:599\n2068#5:602\n2068#5,2:603\n2069#5:605\n*S KotlinDebug\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider$loadLinks$3$1\n*L\n377#1:579,2\n377#1:581\n377#1:583,15\n377#1:600,2\n377#1:582\n377#1:598\n377#1:599\n379#1:602\n382#1:603,2\n379#1:605\n*E\n"})
final class AllMovieLandProvider$loadLinks$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ AllMovieLandProvider.PlayerResponse $player;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ AllMovieLandProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AllMovieLandProvider$loadLinks$3$1(AllMovieLandProvider.PlayerResponse playerResponse, Function1<? super ExtractorLink, Unit> function1, AllMovieLandProvider allMovieLandProvider, Continuation<? super AllMovieLandProvider$loadLinks$3$1> continuation) {
        super(1, continuation);
        this.$player = playerResponse;
        this.$callback = function1;
        this.this$0 = allMovieLandProvider;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AllMovieLandProvider$loadLinks$3$1(this.$player, this.$callback, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:111:0x0417  */
    /* JADX WARN: Code duplicated, block: B:112:0x041a  */
    /* JADX WARN: Code duplicated, block: B:115:0x042c  */
    /* JADX WARN: Code duplicated, block: B:118:0x049b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:119:0x049c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x049c -> B:120:0x04b5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r38) {
        /*
            Method dump skipped, instruction units count: 1294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.AllMovieLandProvider$loadLinks$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$loadLinks$3$1$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider$loadLinks$3$1$1", f = "AllMovieLandProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00081 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AllMovieLandProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00081(AllMovieLandProvider allMovieLandProvider, Continuation<? super C00081> continuation) {
            super(2, continuation);
            this.this$0 = allMovieLandProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00081 = new C00081(this.this$0, continuation);
            c00081.L$0 = obj;
            return c00081;
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
                    $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                    $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
