package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.TvType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: Ultima.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SearchResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.Ultima$search$tasks$1$1", f = "Ultima.kt", i = {}, l = {167, 168}, m = "invokeSuspend", n = {}, nl = {168, 167}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nUltima.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Ultima.kt\ncom/phisher98/Ultima$search$tasks$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,225:1\n1739#2:226\n1814#2,3:227\n*S KotlinDebug\n*F\n+ 1 Ultima.kt\ncom/phisher98/Ultima$search$tasks$1$1\n*L\n170#1:226\n170#1:227,3\n*E\n"})
final class Ultima$search$tasks$1$1 extends SuspendLambda implements Function1<Continuation<? super List<? extends SearchResponse>>, Object> {
    final /* synthetic */ String $pluginName;
    final /* synthetic */ MainAPI $provider;
    final /* synthetic */ String $query;
    int label;
    final /* synthetic */ Ultima this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Ultima$search$tasks$1$1(MainAPI mainAPI, String str, String str2, Ultima ultima, Continuation<? super Ultima$search$tasks$1$1> continuation) {
        super(1, continuation);
        this.$provider = mainAPI;
        this.$query = str;
        this.$pluginName = str2;
        this.this$0 = ultima;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Ultima$search$tasks$1$1(this.$provider, this.$query, this.$pluginName, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super List<? extends SearchResponse>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0056 A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x0013, B:22:0x0052, B:24:0x0056, B:25:0x005a, B:26:0x0076, B:28:0x007c, B:29:0x00c8, B:7:0x0019, B:15:0x0037, B:17:0x003b, B:19:0x0041, B:12:0x0026), top: B:33:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x007c A[Catch: Exception -> 0x001f, LOOP:0: B:26:0x0076->B:28:0x007c, LOOP_END, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x0013, B:22:0x0052, B:24:0x0056, B:25:0x005a, B:26:0x0076, B:28:0x007c, B:29:0x00c8, B:7:0x0019, B:15:0x0037, B:17:0x003b, B:19:0x0041, B:12:0x0026), top: B:33:0x0008 }] */
    public final Object invokeSuspend(Object $result) {
        Object objSearch;
        SearchResponseList searchResponseList;
        Object objSearch2;
        Iterable items;
        Iterable $this$map$iv;
        Ultima ultima;
        String str;
        Collection destination$iv$iv;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objSearch = this.$provider.search(this.$query, 1, (Continuation) this);
                    if (objSearch == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    searchResponseList = (SearchResponseList) objSearch;
                    if (searchResponseList != null || (items = searchResponseList.getItems()) == null) {
                        this.label = 2;
                        objSearch2 = this.$provider.search(this.$query, (Continuation) this);
                        if (objSearch2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        items = (List) objSearch2;
                        if (items == null) {
                            items = CollectionsKt.emptyList();
                        }
                    }
                    $this$map$iv = items;
                    ultima = this.this$0;
                    str = this.$pluginName;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        final SearchResponse item = (SearchResponse) item$iv$iv;
                        destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(ultima, '[' + str + "] " + item.getName(), item.getUrl(), (TvType) null, false, new Function1() { // from class: com.phisher98.Ultima$search$tasks$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return Ultima$search$tasks$1$1.invokeSuspend$lambda$0$0(item, (MovieSearchResponse) obj);
                            }
                        }, 12, (Object) null));
                        $this$map$iv = $this$map$iv;
                    }
                    return (List) destination$iv$iv;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objSearch = $result;
                    searchResponseList = (SearchResponseList) objSearch;
                    if (searchResponseList != null) {
                        break;
                    }
                    this.label = 2;
                    objSearch2 = this.$provider.search(this.$query, (Continuation) this);
                    if (objSearch2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    items = (List) objSearch2;
                    if (items == null) {
                        items = CollectionsKt.emptyList();
                    }
                    $this$map$iv = items;
                    ultima = this.this$0;
                    str = this.$pluginName;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r9.hasNext()) {
                        final SearchResponse item2 = (SearchResponse) item$iv$iv;
                        destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(ultima, '[' + str + "] " + item2.getName(), item2.getUrl(), (TvType) null, false, new Function1() { // from class: com.phisher98.Ultima$search$tasks$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return Ultima$search$tasks$1$1.invokeSuspend$lambda$0$0(item2, (MovieSearchResponse) obj);
                            }
                        }, 12, (Object) null));
                        $this$map$iv = $this$map$iv;
                    }
                    return (List) destination$iv$iv;
                case 2:
                    ResultKt.throwOnFailure($result);
                    objSearch2 = $result;
                    items = (List) objSearch2;
                    if (items == null) {
                        items = CollectionsKt.emptyList();
                    }
                    $this$map$iv = items;
                    ultima = this.this$0;
                    str = this.$pluginName;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r9.hasNext()) {
                        final SearchResponse item3 = (SearchResponse) item$iv$iv;
                        destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(ultima, '[' + str + "] " + item3.getName(), item3.getUrl(), (TvType) null, false, new Function1() { // from class: com.phisher98.Ultima$search$tasks$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return Ultima$search$tasks$1$1.invokeSuspend$lambda$0$0(item3, (MovieSearchResponse) obj);
                            }
                        }, 12, (Object) null));
                        $this$map$iv = $this$map$iv;
                    }
                    return (List) destination$iv$iv;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            Log.INSTANCE.e("Ultima", "Search failed for '" + this.$pluginName + "': " + e.getMessage());
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(SearchResponse $item, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($item.getPosterUrl());
        $this$newMovieSearchResponse.setPosterHeaders($item.getPosterHeaders());
        $this$newMovieSearchResponse.setQuality($item.getQuality());
        $this$newMovieSearchResponse.setId($item.getId());
        return Unit.INSTANCE;
    }
}
