package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003Jc\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001e\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R-\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/AniVortex/TitleWatchResponse;", "", "title", "Lcom/AniVortex/TitleWatchInfo;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "seasons", "", "Lcom/AniVortex/SeasonInfo;", "recommendations", "Lcom/AniVortex/CatalogItem;", "<init>", "(Lcom/AniVortex/TitleWatchInfo;Ljava/util/List;Ljava/util/List;)V", "getTitle", "()Lcom/AniVortex/TitleWatchInfo;", "getSeasons", "()Ljava/util/List;", "getRecommendations", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TitleWatchResponse {

    @JsonProperty("recommendations")
    @Nullable
    private final List<CatalogItem> recommendations;

    @JsonProperty("seasons")
    @Nullable
    private final List<SeasonInfo> seasons;

    @JsonProperty("title")
    @Nullable
    private final TitleWatchInfo title;

    public TitleWatchResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TitleWatchResponse copy$default(TitleWatchResponse titleWatchResponse, TitleWatchInfo titleWatchInfo, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            titleWatchInfo = titleWatchResponse.title;
        }
        if ((i & 2) != 0) {
            list = titleWatchResponse.seasons;
        }
        if ((i & 4) != 0) {
            list2 = titleWatchResponse.recommendations;
        }
        return titleWatchResponse.copy(titleWatchInfo, list, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TitleWatchInfo getTitle() {
        return this.title;
    }

    @Nullable
    public final List<SeasonInfo> component2() {
        return this.seasons;
    }

    @Nullable
    public final List<CatalogItem> component3() {
        return this.recommendations;
    }

    @NotNull
    public final TitleWatchResponse copy(@JsonProperty("title") @Nullable TitleWatchInfo title, @JsonProperty("seasons") @Nullable List<SeasonInfo> seasons, @JsonProperty("recommendations") @Nullable List<CatalogItem> recommendations) {
        return new TitleWatchResponse(title, seasons, recommendations);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleWatchResponse)) {
            return false;
        }
        TitleWatchResponse titleWatchResponse = (TitleWatchResponse) other;
        return Intrinsics.areEqual(this.title, titleWatchResponse.title) && Intrinsics.areEqual(this.seasons, titleWatchResponse.seasons) && Intrinsics.areEqual(this.recommendations, titleWatchResponse.recommendations);
    }

    public int hashCode() {
        return ((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.recommendations != null ? this.recommendations.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TitleWatchResponse(title=" + this.title + ", seasons=" + this.seasons + ", recommendations=" + this.recommendations + ')';
    }

    public TitleWatchResponse(@JsonProperty("title") @Nullable TitleWatchInfo title, @JsonProperty("seasons") @Nullable List<SeasonInfo> list, @JsonProperty("recommendations") @Nullable List<CatalogItem> list2) {
        this.title = title;
        this.seasons = list;
        this.recommendations = list2;
    }

    public /* synthetic */ TitleWatchResponse(TitleWatchInfo titleWatchInfo, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : titleWatchInfo, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2);
    }

    @Nullable
    public final TitleWatchInfo getTitle() {
        return this.title;
    }

    @Nullable
    public final List<SeasonInfo> getSeasons() {
        return this.seasons;
    }

    @Nullable
    public final List<CatalogItem> getRecommendations() {
        return this.recommendations;
    }
}
