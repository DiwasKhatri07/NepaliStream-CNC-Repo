package com.phisher98;

import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.SearchResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/HomePageList;", "catalog", "Lcom/phisher98/StremioC$Catalog;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioC$getMainPage$lists$1", f = "StremioC.kt", i = {0, 0, 0, 0}, l = {136}, m = "invokeSuspend", n = {"catalog", "catalogKey", "cacheKey", "cachedItems"}, nl = {137}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
@SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$getMainPage$lists$1\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1058:1\n460#2,7:1059\n777#3:1066\n873#3,2:1067\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$getMainPage$lists$1\n*L\n143#1:1059,7\n144#1:1066\n144#1:1067,2\n*E\n"})
final class StremioC$getMainPage$lists$1 extends SuspendLambda implements Function2<StremioC.Catalog, Continuation<? super HomePageList>, Object> {
    final /* synthetic */ int $skip;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ StremioC this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioC$getMainPage$lists$1(int i, StremioC stremioC, Continuation<? super StremioC$getMainPage$lists$1> continuation) {
        super(2, continuation);
        this.$skip = i;
        this.this$0 = stremioC;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioC$getMainPage$lists$1 = new StremioC$getMainPage$lists$1(this.$skip, this.this$0, continuation);
        stremioC$getMainPage$lists$1.L$0 = obj;
        return stremioC$getMainPage$lists$1;
    }

    public final Object invoke(StremioC.Catalog catalog, Continuation<? super HomePageList> continuation) {
        return create(catalog, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x009d  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:28:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc A[SYNTHETIC] */
    public final Object invokeSuspend(Object $result) {
        String catalogKey;
        String cacheKey;
        Object homePageList;
        List cachedItems;
        HomePageList freshRow;
        Map $this$getOrPut$iv;
        String str;
        Object value$iv;
        LinkedHashSet answer$iv;
        Set seenForThisCatalog;
        Collection destination$iv$iv;
        SearchResponse item;
        StremioC.Catalog catalog = (StremioC.Catalog) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                catalogKey = catalog.getId();
                cacheKey = catalogKey + '_' + this.$skip;
                List cachedItems2 = (List) this.this$0.pageContentCache.get(cacheKey);
                if (cachedItems2 != null) {
                    String name = catalog.getName();
                    if (name == null) {
                        name = catalog.getId();
                    }
                    freshRow = new HomePageList(name, cachedItems2, false, 4, (DefaultConstructorMarker) null);
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(catalog);
                    this.L$1 = catalogKey;
                    this.L$2 = cacheKey;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(cachedItems2);
                    this.label = 1;
                    homePageList = catalog.toHomePageList(this.this$0, this.$skip, (Continuation) this);
                    if (homePageList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cachedItems = cachedItems2;
                    freshRow = (HomePageList) homePageList;
                    if (!freshRow.getList().isEmpty()) {
                        this.this$0.pageContentCache.put(cacheKey, freshRow.getList());
                    }
                }
                HomePageList row = freshRow;
                $this$getOrPut$iv = this.this$0.catalogSentIds;
                str = catalogKey;
                value$iv = $this$getOrPut$iv.get(str);
                if (value$iv == null) {
                    answer$iv = new LinkedHashSet();
                    $this$getOrPut$iv.put(str, answer$iv);
                } else {
                    answer$iv = value$iv;
                }
                seenForThisCatalog = (Set) answer$iv;
                Iterable $this$filter$iv = row.getList();
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    item = (SearchResponse) element$iv$iv;
                    if (seenForThisCatalog.add(item.getUrl())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                List filteredItems = (List) destination$iv$iv;
                return HomePageList.copy$default(row, (String) null, filteredItems, false, 5, (Object) null);
            case 1:
                cachedItems = (List) this.L$3;
                cacheKey = (String) this.L$2;
                catalogKey = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                homePageList = $result;
                freshRow = (HomePageList) homePageList;
                if (!freshRow.getList().isEmpty()) {
                    this.this$0.pageContentCache.put(cacheKey, freshRow.getList());
                }
                HomePageList row2 = freshRow;
                $this$getOrPut$iv = this.this$0.catalogSentIds;
                str = catalogKey;
                value$iv = $this$getOrPut$iv.get(str);
                if (value$iv == null) {
                    answer$iv = new LinkedHashSet();
                    $this$getOrPut$iv.put(str, answer$iv);
                } else {
                    answer$iv = value$iv;
                }
                seenForThisCatalog = (Set) answer$iv;
                Iterable $this$filter$iv2 = row2.getList();
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    item = (SearchResponse) element$iv$iv;
                    if (seenForThisCatalog.add(item.getUrl())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                List filteredItems2 = (List) destination$iv$iv;
                return HomePageList.copy$default(row2, (String) null, filteredItems2, false, 5, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
