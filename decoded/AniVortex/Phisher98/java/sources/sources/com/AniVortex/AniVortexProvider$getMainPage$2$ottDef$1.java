package com.AniVortex;

import com.lagradost.cloudstream3.HomePageList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AniVortexProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/HomePageList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.AniVortex.AniVortexProvider$getMainPage$2$ottDef$1", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {106}, m = "invokeSuspend", n = {"$this$async", "deferredList", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "it"}, nl = {723}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9"}, v = 2)
@SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$getMainPage$2$ottDef$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,713:1\n1795#2,10:714\n2068#2:724\n2069#2:726\n1805#2:727\n1#3:725\n*S KotlinDebug\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$getMainPage$2$ottDef$1\n*L\n106#1:714,10\n106#1:724\n106#1:726\n106#1:727\n106#1:725\n*E\n"})
final class AniVortexProvider$getMainPage$2$ottDef$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HomePageList>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ AniVortexProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AniVortexProvider$getMainPage$2$ottDef$1(AniVortexProvider aniVortexProvider, Continuation<? super AniVortexProvider$getMainPage$2$ottDef$1> continuation) {
        super(2, continuation);
        this.this$0 = aniVortexProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> aniVortexProvider$getMainPage$2$ottDef$1 = new AniVortexProvider$getMainPage$2$ottDef$1(this.this$0, continuation);
        aniVortexProvider$getMainPage$2$ottDef$1.L$0 = obj;
        return aniVortexProvider$getMainPage$2$ottDef$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<HomePageList>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0149  */
    /* JADX WARN: Code duplicated, block: B:12:0x0195 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x0196  */
    /* JADX WARN: Code duplicated, block: B:16:0x01ae  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0196 -> B:14:0x01aa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.AniVortex.AniVortexProvider$getMainPage$2$ottDef$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
