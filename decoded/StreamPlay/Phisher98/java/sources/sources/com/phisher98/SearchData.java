package com.phisher98;

import androidx.annotation.RecentlyNullable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/phisher98/SearchData;", "Ljava/util/ArrayList;", "Lcom/phisher98/SearchData$SearchDataItem;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "SearchDataItem", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SearchData extends ArrayList<SearchDataItem> {

    /* JADX INFO: compiled from: StreamPlayParser.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Js\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006."}, d2 = {"Lcom/phisher98/SearchData$SearchDataItem;", "", "audio_languages", "", "exact_match", "", "id", "path", "poster", "qualities", "", "release_year", "title", "tmdb_id", "type", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAudio_languages", "()Ljava/lang/String;", "getExact_match", "()I", "getId", "getPath", "getPoster", "getQualities", "()Ljava/util/List;", "getRelease_year", "getTitle", "getTmdb_id", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SearchDataItem {

        @NotNull
        private final String audio_languages;
        private final int exact_match;
        private final int id;

        @NotNull
        private final String path;

        @NotNull
        private final String poster;

        @NotNull
        private final List<String> qualities;

        @NotNull
        private final String release_year;

        @NotNull
        private final String title;
        private final int tmdb_id;

        @NotNull
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchDataItem copy$default(SearchDataItem searchDataItem, String str, int i, int i2, String str2, String str3, List list, String str4, String str5, int i3, String str6, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = searchDataItem.audio_languages;
            }
            if ((i4 & 2) != 0) {
                i = searchDataItem.exact_match;
            }
            if ((i4 & 4) != 0) {
                i2 = searchDataItem.id;
            }
            if ((i4 & 8) != 0) {
                str2 = searchDataItem.path;
            }
            if ((i4 & 16) != 0) {
                str3 = searchDataItem.poster;
            }
            if ((i4 & 32) != 0) {
                list = searchDataItem.qualities;
            }
            if ((i4 & 64) != 0) {
                str4 = searchDataItem.release_year;
            }
            if ((i4 & 128) != 0) {
                str5 = searchDataItem.title;
            }
            if ((i4 & 256) != 0) {
                i3 = searchDataItem.tmdb_id;
            }
            if ((i4 & 512) != 0) {
                str6 = searchDataItem.type;
            }
            int i5 = i3;
            String str7 = str6;
            String str8 = str4;
            String str9 = str5;
            String str10 = str3;
            List list2 = list;
            return searchDataItem.copy(str, i, i2, str2, str10, list2, str8, str9, i5, str7);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAudio_languages() {
            return this.audio_languages;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getExact_match() {
            return this.exact_match;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final List<String> component6() {
            return this.qualities;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getRelease_year() {
            return this.release_year;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final int getTmdb_id() {
            return this.tmdb_id;
        }

        @NotNull
        public final SearchDataItem copy(@NotNull String audio_languages, int exact_match, int id, @NotNull String path, @NotNull String poster, @NotNull List<String> qualities, @NotNull String release_year, @NotNull String title, int tmdb_id, @NotNull String type) {
            return new SearchDataItem(audio_languages, exact_match, id, path, poster, qualities, release_year, title, tmdb_id, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchDataItem)) {
                return false;
            }
            SearchDataItem searchDataItem = (SearchDataItem) other;
            return Intrinsics.areEqual(this.audio_languages, searchDataItem.audio_languages) && this.exact_match == searchDataItem.exact_match && this.id == searchDataItem.id && Intrinsics.areEqual(this.path, searchDataItem.path) && Intrinsics.areEqual(this.poster, searchDataItem.poster) && Intrinsics.areEqual(this.qualities, searchDataItem.qualities) && Intrinsics.areEqual(this.release_year, searchDataItem.release_year) && Intrinsics.areEqual(this.title, searchDataItem.title) && this.tmdb_id == searchDataItem.tmdb_id && Intrinsics.areEqual(this.type, searchDataItem.type);
        }

        public int hashCode() {
            return (((((((((((((((((this.audio_languages.hashCode() * 31) + this.exact_match) * 31) + this.id) * 31) + this.path.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.qualities.hashCode()) * 31) + this.release_year.hashCode()) * 31) + this.title.hashCode()) * 31) + this.tmdb_id) * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchDataItem(audio_languages=" + this.audio_languages + ", exact_match=" + this.exact_match + ", id=" + this.id + ", path=" + this.path + ", poster=" + this.poster + ", qualities=" + this.qualities + ", release_year=" + this.release_year + ", title=" + this.title + ", tmdb_id=" + this.tmdb_id + ", type=" + this.type + ')';
        }

        public SearchDataItem(@NotNull String audio_languages, int exact_match, int id, @NotNull String path, @NotNull String poster, @NotNull List<String> list, @NotNull String release_year, @NotNull String title, int tmdb_id, @NotNull String type) {
            this.audio_languages = audio_languages;
            this.exact_match = exact_match;
            this.id = id;
            this.path = path;
            this.poster = poster;
            this.qualities = list;
            this.release_year = release_year;
            this.title = title;
            this.tmdb_id = tmdb_id;
            this.type = type;
        }

        @NotNull
        public final String getAudio_languages() {
            return this.audio_languages;
        }

        public final int getExact_match() {
            return this.exact_match;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getPath() {
            return this.path;
        }

        @NotNull
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final List<String> getQualities() {
            return this.qualities;
        }

        @NotNull
        public final String getRelease_year() {
            return this.release_year;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final int getTmdb_id() {
            return this.tmdb_id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    public /* bridge */ boolean contains(@RecentlyNullable SearchDataItem p0) {
        return super.contains((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(@RecentlyNullable Object element) {
        if (element instanceof SearchDataItem) {
            return contains((SearchDataItem) element);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(@RecentlyNullable SearchDataItem p0) {
        return super.indexOf((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(@RecentlyNullable Object element) {
        if (element instanceof SearchDataItem) {
            return indexOf((SearchDataItem) element);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(@RecentlyNullable SearchDataItem p0) {
        return super.lastIndexOf((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(@RecentlyNullable Object element) {
        if (element instanceof SearchDataItem) {
            return lastIndexOf((SearchDataItem) element);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ SearchDataItem remove(int index) {
        return removeAt(index);
    }

    public /* bridge */ boolean remove(@RecentlyNullable SearchDataItem p0) {
        return super.remove((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(@RecentlyNullable Object element) {
        if (element instanceof SearchDataItem) {
            return remove((SearchDataItem) element);
        }
        return false;
    }

    public /* bridge */ SearchDataItem removeAt(int p0) {
        return (SearchDataItem) super.remove(p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
