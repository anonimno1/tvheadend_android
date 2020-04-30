/*
 *  Copyright (C) 2020
 *
 * This file is part of TVHClient.
 *
 * TVHClient is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TVHClient is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TVHClient.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dimafon.tvhclient.model;

import android.graphics.Bitmap;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Channel implements Comparable<Channel> {

    public long id;
    public String name;
    public String icon;
    public int number;
    public Set<Programme> epg = Collections.synchronizedSortedSet(new TreeSet<Programme>());
    public Set<Recording> recordings = Collections.synchronizedSortedSet(new TreeSet<Recording>());
    public List<Integer> tags;
    public Bitmap iconBitmap;
    public boolean isTransmitting;
    
    public int compareTo(Channel that) {
        int diff = this.number - that.number;
        if(diff == 0 && this.name!=null){
        	return this.name.compareToIgnoreCase(that.name);
        }
		return diff;
    }

    public boolean hasTag(long id) {
        if (id == 0) {
            return true;
        }

        for (Integer i : tags) {
            if (i == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isRecording() {
        for (Recording rec : recordings) {
            if ("recording".equals(rec.state)) {
                return true;
            }
        }
        return false;
    }

	@Override
	public String toString() {
		return this.name;
	}
    
    
}
