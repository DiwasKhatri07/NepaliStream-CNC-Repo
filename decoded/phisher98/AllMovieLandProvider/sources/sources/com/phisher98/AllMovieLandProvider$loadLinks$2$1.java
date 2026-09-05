package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: AllMovieLandProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AllMovieLandProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.AllMovieLandProvider$loadLinks$2$1", f = "AllMovieLandProvider.kt", i = {1, 2, 2, 2, 2}, l = {329, 330, 332}, m = "invokeSuspend", n = {"m3u8", "m3u8", "$this$forEach$iv", "element$iv", "link"}, nl = {330, 331, 341}, s = {"L$0", "L$0", "L$1", "L$6", "L$7"}, v = 2)
@SourceDebugExtension({"SMAP\nAllMovieLandProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider$loadLinks$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,578:1\n2068#2,2:579\n*S KotlinDebug\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider$loadLinks$2$1\n*L\n331#1:579,2\n*E\n"})
final class AllMovieLandProvider$loadLinks$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ AllMovieLandProvider.FileEntry $file;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ String $playerDomain;
    final /* synthetic */ String $tokenKey;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ AllMovieLandProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AllMovieLandProvider$loadLinks$2$1(AllMovieLandProvider allMovieLandProvider, String str, String str2, AllMovieLandProvider.FileEntry fileEntry, Map<String, String> map, Function1<? super ExtractorLink, Unit> function1, Continuation<? super AllMovieLandProvider$loadLinks$2$1> continuation) {
        super(1, continuation);
        this.this$0 = allMovieLandProvider;
        this.$playerDomain = str;
        this.$tokenKey = str2;
        this.$file = fileEntry;
        this.$headers = map;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AllMovieLandProvider$loadLinks$2$1(this.this$0, this.$playerDomain, this.$tokenKey, this.$file, this.$headers, this.$callback, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:20:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:23:0x0113 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0114  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0114 -> B:25:0x0120). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.AllMovieLandProvider$loadLinks$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
