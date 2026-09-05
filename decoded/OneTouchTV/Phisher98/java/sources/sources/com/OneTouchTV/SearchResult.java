package com.OneTouchTV;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OneTouchTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010!J\u0011\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003JÂ\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0001¢\u0006\u0002\u00107J\u0014\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004J\n\u0010<\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$¨\u0006="}, d2 = {"Lcom/OneTouchTV/SearchResult;", "", "id", "", "loklokContentId", "isSub", "", "title", "image", "type", "year", "source", "status", "loklokCategory", "", "episodes", "", "description", "genres", "otherTitles", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getLoklokContentId", "()Z", "getTitle", "getImage", "getType", "getYear", "getSource", "getStatus", "getLoklokCategory", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEpisodes", "()Ljava/util/List;", "getDescription", "getGenres", "getOtherTitles", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/OneTouchTV/SearchResult;", "equals", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchResult {

    @Nullable
    private final String description;

    @NotNull
    private final List<Object> episodes;

    @NotNull
    private final List<String> genres;

    @Nullable
    private final String id;

    @Nullable
    private final String image;
    private final boolean isSub;

    @Nullable
    private final Long loklokCategory;

    @Nullable
    private final String loklokContentId;

    @NotNull
    private final List<String> otherTitles;

    @Nullable
    private final String source;

    @Nullable
    private final String status;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    @Nullable
    private final String year;

    public SearchResult() {
        this(null, null, false, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getLoklokCategory() {
        return this.loklokCategory;
    }

    @NotNull
    public final List<Object> component11() {
        return this.episodes;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<String> component13() {
        return this.genres;
    }

    @NotNull
    public final List<String> component14() {
        return this.otherTitles;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLoklokContentId() {
        return this.loklokContentId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSub() {
        return this.isSub;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final SearchResult copy(@Nullable String id, @Nullable String loklokContentId, boolean isSub, @Nullable String title, @Nullable String image, @Nullable String type, @Nullable String year, @Nullable String source, @Nullable String status, @Nullable Long loklokCategory, @NotNull List<? extends Object> episodes, @Nullable String description, @NotNull List<String> genres, @NotNull List<String> otherTitles) {
        return new SearchResult(id, loklokContentId, isSub, title, image, type, year, source, status, loklokCategory, episodes, description, genres, otherTitles);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return Intrinsics.areEqual(this.id, searchResult.id) && Intrinsics.areEqual(this.loklokContentId, searchResult.loklokContentId) && this.isSub == searchResult.isSub && Intrinsics.areEqual(this.title, searchResult.title) && Intrinsics.areEqual(this.image, searchResult.image) && Intrinsics.areEqual(this.type, searchResult.type) && Intrinsics.areEqual(this.year, searchResult.year) && Intrinsics.areEqual(this.source, searchResult.source) && Intrinsics.areEqual(this.status, searchResult.status) && Intrinsics.areEqual(this.loklokCategory, searchResult.loklokCategory) && Intrinsics.areEqual(this.episodes, searchResult.episodes) && Intrinsics.areEqual(this.description, searchResult.description) && Intrinsics.areEqual(this.genres, searchResult.genres) && Intrinsics.areEqual(this.otherTitles, searchResult.otherTitles);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.loklokContentId == null ? 0 : this.loklokContentId.hashCode())) * 31) + SearchResult$$ExternalSyntheticBackport0.m6m(this.isSub)) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.source == null ? 0 : this.source.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.loklokCategory == null ? 0 : this.loklokCategory.hashCode())) * 31) + this.episodes.hashCode()) * 31) + (this.description != null ? this.description.hashCode() : 0)) * 31) + this.genres.hashCode()) * 31) + this.otherTitles.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchResult(id=").append(this.id).append(", loklokContentId=").append(this.loklokContentId).append(", isSub=").append(this.isSub).append(", title=").append(this.title).append(", image=").append(this.image).append(", type=").append(this.type).append(", year=").append(this.year).append(", source=").append(this.source).append(", status=").append(this.status).append(", loklokCategory=").append(this.loklokCategory).append(", episodes=").append(this.episodes).append(", description=");
        sb.append(this.description).append(", genres=").append(this.genres).append(", otherTitles=").append(this.otherTitles).append(')');
        return sb.toString();
    }

    public SearchResult(@Nullable String id, @Nullable String loklokContentId, boolean isSub, @Nullable String title, @Nullable String image, @Nullable String type, @Nullable String year, @Nullable String source, @Nullable String status, @Nullable Long loklokCategory, @NotNull List<? extends Object> list, @Nullable String description, @NotNull List<String> list2, @NotNull List<String> list3) {
        this.id = id;
        this.loklokContentId = loklokContentId;
        this.isSub = isSub;
        this.title = title;
        this.image = image;
        this.type = type;
        this.year = year;
        this.source = source;
        this.status = status;
        this.loklokCategory = loklokCategory;
        this.episodes = list;
        this.description = description;
        this.genres = list2;
        this.otherTitles = list3;
    }

    public /* synthetic */ SearchResult(String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, Long l, List list, String str9, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? CollectionsKt.emptyList() : list, (i & 2048) == 0 ? str9 : null, (i & 4096) != 0 ? CollectionsKt.emptyList() : list2, (i & 8192) != 0 ? CollectionsKt.emptyList() : list3);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getLoklokContentId() {
        return this.loklokContentId;
    }

    public final boolean isSub() {
        return this.isSub;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final Long getLoklokCategory() {
        return this.loklokCategory;
    }

    @NotNull
    public final List<Object> getEpisodes() {
        return this.episodes;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<String> getGenres() {
        return this.genres;
    }

    @NotNull
    public final List<String> getOtherTitles() {
        return this.otherTitles;
    }
}
